package com.project.PyeongBang.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select name from user where id=#{id} and password=#{password}") // 로그인
    String getUserName(@Param("name") String name);

    @Insert("insert into user values(#{id}, #{name}, #{password}, #{major})") // 회원가입
    void insertUser(@Param("id") String id, @Param("name") String name, @Param("password") String password, @Param("major") String major);

    @Update("update user set password=#{password} where id=#{id}") // 비밀번호 변경
    void updateUserPwd(@Param("password") String password, @Param("id") String id);

    @Delete("delete from user where id=#{id} and password=#{password}") // 회원 탈퇴
    void deleteUser(@Param("id") String id, @Param("password") String password);



}
