package com.project.PyeongBang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/mainPage")
    public String getMain() {
        return "main page";
    }
}
