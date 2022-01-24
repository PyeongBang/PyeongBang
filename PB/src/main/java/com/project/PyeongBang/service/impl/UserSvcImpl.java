package com.project.PyeongBang.service.impl;

import com.project.PyeongBang.mapper.UserMapper;
import com.project.PyeongBang.service.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvcImpl implements UserSvc {
    @Autowired
    private UserMapper mapper;

    /** 사용자 로그인 */
    public String login(String id, String pwd){ // 구현 완료
        return this.mapper.login(id, pwd);
    }

    /** 회원가입 중복확인 */
    public String duplicateCheck(String id){
        return this.mapper.duplicateCheck(id);
    }

    /** 회원가입 */
    public void insertUser(String id, String name, String pwd, String major){ // 구현 완료
        this.mapper.insertUser(id, name, pwd, major);
    }

    /** 비밀번호 수정 */
    public void updateUserPwd(String id, String updatePwd){
        this.mapper.updateUserPwd(id, updatePwd);
    } // 구현 완료

    /** 회원 탈퇴 */
    public void deleteUser(String id, String pwd){ // 구현 완료
        this.mapper.deleteUser(id, pwd);
    }
}
