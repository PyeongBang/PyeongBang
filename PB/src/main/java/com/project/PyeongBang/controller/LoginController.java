package com.project.PyeongBang.controller;

import com.project.PyeongBang.service.UserSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final UserSvc userService;

    @RequestMapping("/main/login") // 로그인
    public String login(HttpServletRequest httpServletRequest) throws Exception {
        String id = httpServletRequest.getParameter("id");
        String pw = httpServletRequest.getParameter("pwd");
        return userService.login(id, pw); // return 사용자 이름
    }

    @RequestMapping("/main/joinMember") // 회원가입
    public String joinMember(HttpServletRequest httpServletRequest) throws Exception {
        String id = httpServletRequest.getParameter("id");
        String name = httpServletRequest.getParameter("name");
        String pwd = httpServletRequest.getParameter("pwd");
        String major = httpServletRequest.getParameter("major");
        userService.insertUser(id, name, pwd, major);
        return "login/page/url"; // return 로그인 페이지 direct
    }
}
