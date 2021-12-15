package com.project.PyeongBang.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    // 로그인
    @Select("select name from user where id=#{id} and pwd=#{pwd}")
    String login(@Param("id") String id, @Param("pwd") String pwd);

    // 회원가입
    @Insert("insert into user values(#{id}, #{name}, #{pwd}, #{major})")
    void insertUser(@Param("id") String id, @Param("name") String name, @Param("pwd") String pwd, @Param("major") String major);

    // 비밀번호 변경
    @Update("update user set pwd=#{pwd} where id=#{id}")
    void updateUserPwd(@Param("id") String id, @Param("pwd") String pwd);

    // 회원 탈퇴
    @Delete("delete from user where id=#{id} and pwd=#{pwd}")
    void deleteUser(@Param("id") String id, @Param("pwd") String pwd);
}
