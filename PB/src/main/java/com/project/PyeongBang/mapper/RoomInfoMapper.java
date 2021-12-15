package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RoomInfoDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomInfoMapper {

    // 방 리스트 전체 가져오기
    @Select("select * from roominfo")
    List<RoomInfoDto> getAllRoomInfo();

    //특정 방 id 정보 가져오기
    @Select("select * from roominfo where room_id = #{room_id}")
    List<RoomInfoDto> getRoomInfo(@Param("room_id") int room_id);

    // 빌딩 이름으로 검색하기
    @Select("select * from roominfo where building_name like CONCAT('%',#{building_name},'%')")
    List<RoomInfoDto> selectBuildingName(@Param("building_name") String building_name);

    @Select("select * from roominfo where address like CONCAT('%',#{building_name},'%')")
    List<RoomInfoDto> selectAddress(@Param("building_name") String building_name);

    // room information 추가
    @Insert("insert into roominfo values(#{room_id}, #{realStates_phone}, #{building_name}, #{room_type}, #{address}," +
            " #{monthly_estimated_cost}, #{monthly}, #{administrative_expense}, #{parking}, #{short_term_rental}")
    void insertRoomInfo(@Param("room_id") int room_id, @Param("realStates_phone") String realStates_phone, @Param("building_name") String building_name,
                        @Param("room_type") String room_type, @Param("address") String address, @Param("monthly_estimated_cost") String monthly_estimated_cost,
                        @Param("monthly") String monthly, @Param("administrative_expense") String administrative_expense, @Param("parking") String parking,
                        @Param("short_term_rental") boolean short_term_rental);
}
