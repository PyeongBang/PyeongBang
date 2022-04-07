package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel(value = "매물 관련 전체 정보", description = "매물 관련 전체 정보를 하나의 객체로 모으기 위한 Model")
public class DetailBeforeDto {
    private RoomInfoDto info;
    private RoomDetailsDto details;
    private RoomOptionsDto options;
    private String distance;
    public DetailBeforeDto(RoomInfoDto info, RoomDetailsDto details, RoomOptionsDto options, String distance){
        this.info = info;
        this.details = details;
        this.options = options;
        this.distance = distance;
    }
}
