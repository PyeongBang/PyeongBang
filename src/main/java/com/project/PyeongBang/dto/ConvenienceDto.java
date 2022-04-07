package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ApiModel(value = "편의점 위치", description = "자취촌에 있는 편의점의 위치 정보")
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
