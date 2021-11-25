package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealStatesDto {
    private String name;
    private String address;
    private String number;
    public RealStatesDto(String name, String address, String number){
        this.name = name;
        this.address = address;
        this.number = number;
    }
}
