package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.RealStatesDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MainSvc mainService;

    @ApiOperation(value="메인 페이지 호출", notes="메인 페이지에 부동산 정보 리스트를 전송")
    @GetMapping("/main") // main page
    public Map<String, List<RealStatesDto>> getMain() {
        return mainService.getMain();
    }
}
