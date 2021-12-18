package com.project.PyeongBang.dto;

import lombok.Getter;

@Getter
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
