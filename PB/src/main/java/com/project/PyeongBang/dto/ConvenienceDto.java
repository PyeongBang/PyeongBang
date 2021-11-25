package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvenienceDto {
    private String name;
    private String address;
    public ConvenienceDto(String name, String address){
        this.name = name;
        this.address = address;
    }
}
