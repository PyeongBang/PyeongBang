package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ApiModel(value="로그인", description = "아이디와 패스워드를 가진 Domain")
public class LoginDto {
    @ApiModelProperty(value="아이디")
    @NotEmpty(message = "id를 입력해주세요")
    private String id;

    @ApiModelProperty(value="패스워드")
    @Length(min = 3, message = "비밀번호는 3자리 이상 입력해주세요")
    private String pwd;

    public void LoginDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
}
