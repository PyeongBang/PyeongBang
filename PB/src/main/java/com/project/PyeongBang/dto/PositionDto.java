package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDto {
    private String name;
    private String x;
    private String y;
    public PositionDto(String name, String x, String y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
