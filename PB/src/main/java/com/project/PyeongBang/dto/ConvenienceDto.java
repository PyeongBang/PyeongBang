package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvenienceDto {
    private String address;
    private String name;
    public ConvenienceDto(String address, String name){
        this.address = address;
        this.name = name;
    }
}
