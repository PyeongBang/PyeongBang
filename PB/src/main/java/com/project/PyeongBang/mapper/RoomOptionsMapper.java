package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RoomDetailsDto;
import com.project.PyeongBang.dto.RoomOptionsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomOptionsMapper {

    // 건물 이름에 부합하는 방의 옵션들을 가져옴
    @Select("select * from roomoptions where building_name = #{building_name}")
    List<RoomOptionsDto> getRoomOptions(@Param("building_name") int building_name);

    // room option 추가하기
    @Insert("insert into roomoptions values(#{building_name}, #{induction}, #{microwave}, #{airConditioner}, #{tv}," +
            "#{bed}, #{desk}, #{shoeCloset}, #{gasRange}, #{refrigerator}, #{doorLock}, #{fireAlarm}, #{videoPhone}," +
            "#{common_entrance}, #{cctv}, #{interPhone} ")
    void insertRoomOptions(@Param("building_name") String building_name, @Param("induction") boolean induction,
                           @Param("microwave") boolean microwave, @Param("airConditioner") boolean airConditioner,
                           @Param("tv") boolean tv, @Param("bed") boolean bed, @Param("desk") boolean desk,
                           @Param("shoeCloset") boolean shoeCloset, @Param("gasRange") boolean gasRange,
                           @Param("refrigerator") boolean refrigerator, @Param("doorLock") boolean doorLock,
                           @Param("fireAlarm") boolean fireAlarm, @Param("videoPhone") boolean videoPhone,
                           @Param("common_entrance") boolean common_entrance, @Param("cctv") boolean cctv,
                           @Param("interPhone") boolean interPhone);
}
