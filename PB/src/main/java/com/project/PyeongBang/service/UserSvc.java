package com.project.PyeongBang.service;

import com.project.PyeongBang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {

    @Autowired
    private UserMapper mapper;

    public String login(String id, String pwd){ // 구현 완료
        return this.mapper.login(id, pwd);
    }

    public String duplicateCheck(String id){
        return this.mapper.duplicateCheck(id);
    }

    public void insertUser(String id, String name, String pwd, String major){ // 구현 완료
        this.mapper.insertUser(id, name, pwd, major);
    }

    public void updateUserPwd(String id, String updatePwd){
        this.mapper.updateUserPwd(id, updatePwd);
    } // 구현 완료

    public void deleteUser(String id, String pwd){ // 구현 완료
        this.mapper.deleteUser(id, pwd);
    }
}
