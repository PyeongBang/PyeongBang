package com.project.PyeongBang.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select name from user where id=#{id} and pwd=#{pwd}") // 로그인
    String login(@Param("id") String id, @Param("pwd") String pwd);

    @Insert("insert into user values(#{id}, #{name}, #{pwd}, #{major})") // 회원가입
    void insertUser(@Param("id") String id, @Param("name") String name, @Param("pwd") String pwd, @Param("major") String major);

    @Update("update user set pwd=#{pwd} where id=#{id}") // 비밀번호 변경
    void updateUserPwd(@Param("id") String id, @Param("pwd") String pwd);

    @Delete("delete from user where id=#{id} and password=#{pwd}") // 회원 탈퇴
    void deleteUser(@Param("id") String id, @Param("pwd") String pwd);
}
