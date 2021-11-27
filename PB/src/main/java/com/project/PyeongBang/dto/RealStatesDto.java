package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealStatesDto {
    private String phone;
    private String user_id;
    private String name;
    private String address;
    public RealStatesDto(String phone, String user_id, String name, String address){
        this.phone = phone;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
    }
}
