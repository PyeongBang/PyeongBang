package com.project.PyeongBang.service.impl;

import com.project.PyeongBang.dto.RealStatesDto;
import com.project.PyeongBang.mapper.RealStatesMapper;
import com.project.PyeongBang.service.MainSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainSvcImpl implements MainSvc {
    @Autowired
    private RealStatesMapper realStatesMapper;

    /** 메인 페이지 공인중개사 목록 가져오기 */
    public Map<String, List<RealStatesDto>> getRealStatesList(){
        Map<String, List<RealStatesDto>> realStates_map = new HashMap<>();
        List<RealStatesDto> realStates_list = new ArrayList(realStatesMapper.getRealStates());
        realStates_map.put("realStatesInfo", realStates_list);
        return realStates_map;
    }
}
