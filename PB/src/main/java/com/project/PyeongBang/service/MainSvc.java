package com.project.PyeongBang.service;

import com.project.PyeongBang.dto.RealStatesDto;
import com.project.PyeongBang.mapper.RealStatesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainSvc {
    @Autowired
    private RealStatesMapper realStatesMapper;

    public Map<String, List<RealStatesDto>> getMain(){ // 메인 페이지에 공인중개사 데이터 전송
        Map<String, List<RealStatesDto>> realStates_map = new HashMap<>();
        List<RealStatesDto> realStates_list = new ArrayList(realStatesMapper.getRealStates());
        realStates_map.put("realStatesInfo", realStates_list);
        return realStates_map;
    }
}
