package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginDto {
    @NotEmpty(message = "id를 입력해주세요")
    private String id;
    @Length(min = 3, message = "비밀번호는 3자리 이상 입력해주세요")
    private String pwd;

    public void LoginDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
}
