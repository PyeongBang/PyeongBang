package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.ConvenienceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConvenienceMapper {
    // 편의점 위치 출력
    @Select("select * from convenience")
    List<ConvenienceDto> getConvenience();
}
