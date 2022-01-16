package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RealStatesDto {
    @NotEmpty(message = "부도산 전화번호는 필수 입력 값 입니다.")
    private String phone;
    @NotEmpty(message = "본인 아이디는 필수 입력 값 입니다.")
    private String user_id;
    @NotEmpty(message = "부도산 이름은 필수 입력 값 입니다.")
    private String name;
    @NotEmpty(message = "부동산 주소는 필수 입력 값 입니다.")
    private String address;
    public RealStatesDto(String phone, String user_id, String name, String address){
        this.phone = phone;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
    }
}
