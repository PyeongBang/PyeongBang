package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;
    private String password;
    private String major;

    public UserDto(String id, String name, String password, String major){
        this.id = id;
        this.name = name;
        this.password = password;
        this.major = major;
    }
}
