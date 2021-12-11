package com.project.PyeongBang.mapper;

import com.project.PyeongBang.dto.RealStatesDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RealStatesMapper {
    // main page 공인중개사 리스트 출력 good
    @Select("select * from realstates")
    List<RealStatesDto> getRealStates();

    @Insert("insert into realstates values(#{phone}, #{user_id}, #{name}, #{address})") // 공인중개사 추가 name : 공인중개사 이름
    void insertUser(@Param("phone") String phone, @Param("user_id") String user_id, @Param("name") String name, @Param("address") String address);

    @Delete("delete from realstates where phone=#{phone} and user_id=#{user_id}") // 공인중개사 삭제
    void deleteUser(@Param("phone") String phone, @Param("user_id") String user_id);
}
