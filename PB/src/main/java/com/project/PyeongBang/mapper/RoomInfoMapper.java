package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RealStatesDto;
import com.project.PyeongBang.dto.RoomInfo;
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
    @Select("select * from room_info")
    List<RoomInfo> getAllRoomInfo();

    //특정 방 id 정보 가져오기
    @Select("select * from room_info where room_id = #{id}")
    List<RoomInfo> getRoomInfo(@Param("room_id") int room_id);

    // 빌딩 이름으로 검색하기
    @Select("select * from room_info where building_name = #{building_name}")
    List<RoomInfo> selectBuildingName(@Param("building_name") String building_name);

    // room information 추가
    @Insert("insert into room_info values(#{room_id}, #{realStates_phone}, #{building_name}, #{room_type}, #{address}," +
            " #{monthly_estimated_cost), #{monthly}, #{administrative_expense}, #{parking}, #{short_term_rental}")
    void insertRoomInfo(@Param("room_id") int room_id, @Param("realStates_phone") String realStates_phone, @Param("building_name") String building_name,
                        @Param("room_type") String room_type, @Param("address") String address, @Param("monthly_estimated_cost") String monthly_estimated_cost,
                        @Param("monthly") String monthly, @Param("administrative_expense") String administrative_expense, @Param("parking") String parking,
                        @Param("short_term_rental") boolean short_term_rental);
}
