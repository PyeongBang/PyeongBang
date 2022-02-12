package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDto {
    @NotEmpty(message="빈값이면 안됩니다")
    private String id;

    private String name;

    @Length(min = 3, message ="비밀면호는 3자리 이상으로 입력해 주세요")
    private String pwd;

    private String major;

    public void UserDto(String id, String name, String pwd, String major){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.major = major;
    }

    public void LoginDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
}
