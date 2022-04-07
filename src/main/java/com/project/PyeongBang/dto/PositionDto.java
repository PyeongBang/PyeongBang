package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "건물 위치 정보", description = "매물과 학교 전공 건물과의 거리 계산")
public class PositionDto {
    @ApiModelProperty(example = "학교 건물 이름")
    private String name;
    @ApiModelProperty(example = "건물 X 좌표")
    private String x;
    @ApiModelProperty(example = "건물 Y 좌표")
    private String y;
    public PositionDto(String name, String x, String y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
