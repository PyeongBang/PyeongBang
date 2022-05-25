package com.project.PyeongBang.service;

import com.project.PyeongBang.dto.UserDto;

public interface UserSvc {

    /** 사용자 로그인 */
    public UserDto login(String id, String pwd) throws Exception;

    /** 회원가입 중복확인 */
    public String duplicateCheck(String id) throws Exception;

    public UserDto getUserInfo(String id) throws Exception;

    /** 회원가입 */
    public void insertUser(String id, String name, String pwd, String major) throws Exception;

    /** 비밀번호 수정 */
    public void updateUserPwd(String id, String updatePwd) throws Exception;

    /** 회원탈퇴 */
    public void deleteUser(String id, String pwd) throws  Exception;

}
