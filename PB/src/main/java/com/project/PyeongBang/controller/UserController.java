package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.UserDto;
import com.project.PyeongBang.dto.validation.LoginValidator;
import com.project.PyeongBang.dto.validation.UserValidator;
import com.project.PyeongBang.service.UserSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserSvc userService;

    // 로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public String login(@RequestBody UserDto req, Errors errors) throws Exception {

        // login validation check
        new LoginValidator().validate(req, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }
        return userService.login(req.getId(), req.getPwd());
    }

    // 회원가입
    @ResponseBody
    @RequestMapping(value = "/newMember", method = RequestMethod.POST, produces = "application/json")
    public String joinMember(@RequestBody UserDto req, Errors errors) throws Exception {

        // user validation check
        new UserValidator().validate(req, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }

        userService.insertUser(req.getId(), req.getName(), req.getPwd(), req.getMajor());
        return "login page url"; // return 로그인 페이지
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 모든 세션을 종료
        /* 특정 세션만 종료  session에 해당하는 이름을 매개변수에 넣기
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
         */
        return "login page url";
    }

    // 비밀번호 수정 후 재로그인
    @PutMapping("/modify")
    public String modifyMember(HttpServletRequest httpServletRequest, HttpSession session) throws Exception {
        // 기존 id와 변경을 원하는 새로운 pwd를 입력받기
        String id = httpServletRequest.getParameter("id");
        String pwd = httpServletRequest.getParameter("pwd"); // 변경을 원하는 pwd
        userService.updateUserPwd(id, pwd);
        session.invalidate(); // pwd 변경 후 로그아웃 (세션 초기화)
        return "login page url"; // 로그인 페이지 direct
    }

    // 회원 탈퇴
    @DeleteMapping("/delete")
    public String deleteMember(HttpServletRequest httpServletRequest){
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
}
