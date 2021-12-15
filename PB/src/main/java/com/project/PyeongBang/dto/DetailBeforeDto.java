package com.project.PyeongBang.dto;

import lombok.Getter;

@Getter
public class DetailBeforeDto {
    private RoomInfoDto info;
    private RoomDetailsDto details;
    private RoomOptionsDto options;
    public DetailBeforeDto(RoomInfoDto info, RoomDetailsDto details, RoomOptionsDto options){
        this.info = info;
        this.details = details;
        this.options = options;
    }
}
