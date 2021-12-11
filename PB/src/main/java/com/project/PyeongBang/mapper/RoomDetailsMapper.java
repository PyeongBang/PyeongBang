package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RoomDetailsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomDetailsMapper {

    // room_id와 일치하는 room의 세부 정보 가져오기
    @Select("select * from roomdetails where room_id = #{room_id}")
    List<RoomDetailsDto> getRoomDetails(@Param("room_id") int room_id);

    // room details 정보 추가하기
    @Insert("insert into roomdetails values(#{num}, #{room_id}, #{floor}, #{size}, #{room_cnt}, #{heating}, " +
            "#{built_in}, #{parking}, #{elevator}, #{balcony}, #{move_in_date}, #{approved_date})")
    void insertUser(@Param("num") int num, @Param("room_id") int room_id, @Param("floor") int floor, @Param("size") String size,
                    @Param("room_cnt") int room_cnt, @Param("heating") String heating, @Param("built_in") String built_in,
                    @Param("parking") boolean parking, @Param("elevator") boolean elevator, @Param("balcony") boolean balcony,
                    @Param("move_in_date") String move_in_date, @Param("approved_date") String approved_date);
}
