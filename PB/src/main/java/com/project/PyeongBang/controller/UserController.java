package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.LoginDto;
import com.project.PyeongBang.dto.UserDto;
import com.project.PyeongBang.service.JwtSvc;
import com.project.PyeongBang.service.UserSvc;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private final UserSvc userService;
    @Autowired
    private final JwtSvc jwtSvc;

    // 로그인
    @ApiOperation(value = "로그인 기능", notes = "id와 pwd 입력, 로그인 성공 시 메인 페이지로 이동")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public String login(@Valid @RequestBody LoginDto req, BindingResult bindingResult) throws Exception {


        /** common class validation check**/
        /*
        new LoginValidator().validate(req, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }
        return userService.login(req.getId(), req.getPwd())
         */

        /** hibernate validator check **/
        if(bindingResult.hasErrors()){
            // 필수 값을 입력하지 않은 경우 return error
            return bindingResult.getFieldError().getField();
        }

        UserDto userDto = userService.login(req.getId(), req.getPwd());

        // 전공이 있는 경우 학생으로 취급, 부동산인 경우 공인중개사 및 부동산으로 취급
        // 부동산의 경우 매물을 올릴 수 있는 권한 jwt를 생성(60분)
        if(userDto.getMajor() != null){
            if(userDto.getMajor().equals("부동산")){
                jwtSvc.createJwt(req.getId(), req.getPwd());
            }
            return "login success, main page url";
        }
        return "login failed, login page url";
    }

    // 회원가입
    @ApiOperation(value = "회원가입 기능", notes = "필수 값으로 입력 후 id 중복확인 및 회원가입 진행")
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
        if(bindingResult.hasErrors()){
            System.out.println(1);
            return bindingResult.getFieldError().toString();
        }
        if(userService.duplicateCheck(req.getId()) != null){
            System.out.println(2);
            return "동일한 id가 이미 존재합니다. 다른 아이디를 입력해주세요";
        }
        System.out.println(3);
        userService.insertUser(req.getId(), req.getName(), req.getPwd(), req.getMajor());
        System.out.println(4);
        return "login page url"; // return 로그인 페이지
    }

    // 로그아웃
    @ApiOperation(value="로그아웃", notes="전체 세션 종료")
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 모든 세션을 종료
        /* 특정 세션만 종료  session에 해당하는 이름을 매개변수에 넣기
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
         */
        return "login page url";
    }

    // 비밀번호 수정 후 재로그인
    @ApiOperation(value = "비밀번호 수정", notes ="비밀번호 수정 후 재로그인 페이지로 이동")
    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "application/json")
    public String modifyMember(@Valid @RequestBody LoginDto req, BindingResult bindingResult, HttpSession session) throws Exception {
        // 기존 id와 변경을 원하는 새로운 pwd를 입력받기

        if(userService.duplicateCheck(req.getId()) == null){
            return "존재하지 않는 아이디 입니다. 재시도 바랍니다.";
        }
        userService.updateUserPwd(req.getId(), req.getPwd());
        session.invalidate(); // pwd 변경 후 로그아웃 (세션 초기화)
        return "login page url"; // 로그인 페이지 direct
    }

    // 회원 탈퇴
    @ApiOperation(value="회원탈퇴", notes = "id와 pwd 입력을 통한 인증 후 회원탈퇴")
    @DeleteMapping("/delete")
    public String deleteMember(HttpServletRequest httpServletRequest) throws Exception{
        String id = httpServletRequest.getParameter("id");
        String pwd = httpServletRequest.getParameter("pwd");
        if(userService.login(id, pwd) == null){
            // 회원탈퇴 인증 실패
            return "delete page url"; // 회원탈퇴 페이지로 다시 이동
        }else{
            userService.deleteUser(id, pwd);
            return "main page url"; // 메인 페이지로 이동
        }
    }

    @ApiOperation(value="토큰 유효성 검사", notes = "특정 페이지 접근 시 토큰 검증을 통한 페이지 접근 제어")
    @RequestMapping(value = "/jwt", method=RequestMethod.GET, produces = "application/json")
    public String chk_jwt(HttpServletRequest req) throws Exception {
        String token = req.getHeader("token");
        if(!jwtSvc.checkJwt(token)){
            return "부동산 사업자가 아닙니다. 매물을 추가할 수 없습니다.";
        }
        return req.getParameter("url");
    }
}
