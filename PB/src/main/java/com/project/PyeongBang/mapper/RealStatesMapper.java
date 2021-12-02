package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RealStatesDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RealStatesMapper {
    @Select("select * from realstates") //공인중개사 모든 데이터 출력
    List<RealStatesDto> getRealStates();


}
