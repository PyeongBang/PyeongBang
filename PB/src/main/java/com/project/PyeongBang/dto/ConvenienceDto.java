package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ConvenienceDto {
    @NotEmpty(message = "주소를 입력해주세요")
    private String address;
    @NotEmpty(message = "편의시설 이름을 입력해주세요")
    private String name;
    public ConvenienceDto(String address, String name){
        this.address = address;
        this.name = name;
    }
}
