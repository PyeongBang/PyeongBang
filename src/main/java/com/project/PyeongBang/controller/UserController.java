package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.TokenResponseDto;
import com.project.PyeongBang.dto.UserDto;
import com.project.PyeongBang.service.JwtSvc;
import com.project.PyeongBang.service.UserSvc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController(value = "/user")
public class UserController {

    @Autowired
    private final UserSvc userService;
    @Autowired
    private final JwtSvc jwtSvc;

    // 로그인
    @ApiOperation(value = "로그인 기능", notes = "id와 pwd 입력, 로그인 성공 시 메인 페이지로 이동")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "사용자 이름", required = true),
            @ApiImplicitParam(name = "pwd", value = "사용자 비밀번호", required = true),
    })
    @Transactional
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> login(@Valid @RequestBody UserDto req, HttpServletResponse response, BindingResult bindingResult) throws Exception {


        /** common class validation check**/
        /*
        new LoginValidator().validate(req, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }
        return userService.login(req.getId(), req.getPwd())
         */

        /** hibernate validator check **/
        if (bindingResult.hasErrors()) {
            // 필수 값을 입력하지 않은 경우 return error
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        UserDto userDto = userService.login(req.getId(), req.getPwd());

        // 전공이 있는 경우 학생으로 취급, 부동산인 경우 공인중개사 및 부동산으로 취급
        // 부동산의 경우 매물을 올릴 수 있는 권한 jwt를 생성(60분)
        String token = "";
        if (userDto.getMajor() != null && userDto.getMajor().equals("부동산")) {
            token = jwtSvc.createJwt(req.getId(), req.getPwd());
        }
        if ("".equals(token)) return new ResponseEntity(HttpStatus.OK);
        else {
            /** refreshToken은 Header의 set-cookie에 담고 accessToken은 JSON Body에 담아서 리턴*/
            TokenResponseDto tokenResponseDto = new TokenResponseDto(token, "bearer");
            ResponseCookie responseCookie = ResponseCookie.from("refreshToken", "refreshToken")
                    .httpOnly(true) // XSS에 의한 공격 위험을 완화, js로의 접근이 불가능
                    .secure(true)
                    .path("/index.html")
                    .maxAge(60)
                    .domain("done.net")
                    .build();

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                    .body(responseCookie);
        }
    }

    // 회원가입
    @ApiOperation(value = "회원가입 기능", notes = "필수 값으로 입력 후 id 중복확인 및 회원가입 진행")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "사용자 아이디", required = true),
            @ApiImplicitParam(name = "pwd", value = "사용자 비밀번호", required = true),
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true),
            @ApiImplicitParam(name = "major", value = "사용자 전공", required = false)
    })
    @ResponseBody
    @RequestMapping(value = "/newMember", method = RequestMethod.POST, produces = "application/json")
    public String joinMember(@Valid @RequestBody UserDto req, BindingResult bindingResult) throws Exception {

        /** user validation check**/
        /*
        new UserValidator().validate(req, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }
         */

        /** hibernate validator check **/
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().toString();
        }
        if (!StringUtils.hasText(req.getName())) {
            return "이름은 필수입니다.";
        }
        if (userService.duplicateCheck(req.getId()) != null) {
            return "동일한 id가 이미 존재합니다. 다른 아이디를 입력해주세요";
        }
        userService.insertUser(req.getId(), req.getName(), req.getPwd(), req.getMajor());
        return "/login"; // return 로그인 페이지
    }

    // 로그아웃
    @ApiOperation(value = "로그아웃", notes = "전체 세션 종료")
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate(); // 모든 세션을 종료
        /* 특정 세션만 종료 시 session에 해당하는 이름을 매개변수에 넣기
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
         */
        return "/index.html";
    }

    // 비밀번호 수정 후 재로그인
    @ApiOperation(value = "비밀번호 수정", notes = "비밀번호 수정 후 재로그인 페이지로 이동")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "유저 아이디", required = true),
            @ApiImplicitParam(name = "pwd", value = "유저 비밀번호", required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.PUT, produces = "application/json")
    public boolean modifyMember(@Valid @RequestBody UserDto request, BindingResult bindingResult, HttpSession session, HttpServletResponse response) throws Exception {
        // 기존 id와 변경을 원하는 새로운 pwd를 입력받기

        if (userService.duplicateCheck(request.getId()) == null) {
            return false; // 본인 인증 실패
        }
        userService.updateUserPwd(request.getId(), request.getPwd());
        session.invalidate(); // pwd 변경 후 로그아웃 (세션 초기화)
        response.sendRedirect("login page");
        return true;
    }

    // 회원 탈퇴
    @ApiOperation(value = "회원탈퇴", notes = "id와 pwd 입력을 통한 인증 후 회원탈퇴")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "유저 아이디", required = true),
            @ApiImplicitParam(name = "pwd", value = "유저 비밀번호", required = true)
    })
    @DeleteMapping("/delete")
    public String deleteMember(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        if (userService.login(id, pwd) == null) {
            // 회원탈퇴 인증 실패
            return "/usr/delete";
        } else {
            userService.deleteUser(id, pwd);
            return "/index.html";
        }
    }

    @ApiOperation(value = "토큰 유효성 검사", notes = "특정 페이지 접근 시 토큰 검증을 통한 페이지 접근 제어")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "유저 토큰", required = true),
            @ApiImplicitParam(name = "url", value = "토큰 유효성에 따른 페이지 url", required = true)
    })
    @RequestMapping(value = "/jwt", method = RequestMethod.POST, produces = "application/json")
    public String chk_jwt(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        String url = request.getHeader("url");
        if (!jwtSvc.checkJwt(token)) {
            return "/index.html"; // 부동산 사업자가 아닌 경우
        } else {
            return url;
        }
    }
}
