package com.project.PyeongBang.service;

import com.project.PyeongBang.dto.RealStatesDto;

import java.util.List;
import java.util.Map;


public interface MainSvc {

    /** 메인 페이지 공인중개사 목록 전송 */
    public Map<String, List<RealStatesDto>> getRealStatesList() throws Exception;

}
