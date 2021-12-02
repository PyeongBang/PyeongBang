package com.project.PyeongBang.service;

import com.project.PyeongBang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {

    @Autowired
    private UserMapper mapper;

    public String login(String id, String pwd) throws Exception{
        return this.mapper.login(id, pwd);
    }

    public void insertUser(String id, String name, String pwd, String major) throws Exception{
        this.mapper.insertUser(id, name, pwd, major);
    }

    public void updateUserPwd(String id, String updatePwd) throws Exception{
        this.mapper.updateUserPwd(id, updatePwd);
    }

    public void deleteUser(String id, String pwd) throws Exception{
        this.mapper.deleteUser(id, pwd);
    }
}
