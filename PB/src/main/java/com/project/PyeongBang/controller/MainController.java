package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.RealStatesDto;
import com.project.PyeongBang.service.MainSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MainSvc mainService;

    @GetMapping("/main")
    public Map<String, List<RealStatesDto>> getMain() {
        return mainService.getMain();
    }
}
