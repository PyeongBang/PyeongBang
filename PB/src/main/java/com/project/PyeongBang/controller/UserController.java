package com.project.PyeongBang.controller;

import com.project.PyeongBang.service.UserSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserSvc userService;

    @PostMapping("/login") // 로그인
    public String login(HttpServletRequest httpServletRequest) throws Exception {
        String id = httpServletRequest.getParameter("id");
        String pwd = httpServletRequest.getParameter("pwd");
        return userService.login(id, pwd); // return 사용자 이름
    }

    @PostMapping("/newMember") // 회원가입
    public String joinMember(HttpServletRequest httpServletRequest) throws Exception {
        String id = httpServletRequest.getParameter("id");
        String name = httpServletRequest.getParameter("name");
        String pwd = httpServletRequest.getParameter("pwd");
        String major = httpServletRequest.getParameter("major");
        userService.insertUser(id, name, pwd, major);
        return "login page url"; // return 로그인 페이지
    }

    @GetMapping("/logout") // 로그아웃
    public String logout(HttpSession session){
        session.invalidate(); // 모든 세션을 종료
        /* 특정 세션만 종료  session에 해당하는 이름을 매개변수에 넣기
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
         */
        return "login page url";
    }

    @PutMapping("/modify") // 비밀번호 수정 후 재로그인
    public String modifyMember(HttpServletRequest httpServletRequest, HttpSession session) throws Exception {
        // 기존 id와 변경을 원하는 새로운 pwd를 입력받기
        String id = httpServletRequest.getParameter("id");
        String pwd = httpServletRequest.getParameter("pwd"); // 변경을 원하는 pwd
        userService.updateUserPwd(id, pwd);
        session.invalidate(); // pwd 변경 후 로그아웃 (세션 초기화)
        return "login page url"; // 로그인 페이지 direct
    }

    @DeleteMapping("/delete") // 회원 탈퇴
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
