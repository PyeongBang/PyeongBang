package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.PositionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PositionMapper {
    @Select("select * from positiondata where name like CONCAT('%',#{name},'%')")
    PositionDto getPosition(@Param("name") String name);
}
