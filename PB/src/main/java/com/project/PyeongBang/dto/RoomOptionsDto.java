package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RoomOptionsDto {
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String building_name; // 건물명
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean induction;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean microwave;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean airConditioner;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean tv;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean bed;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean desk;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean shoeCloset;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean gasRange;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean refrigerator;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean doorLock;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean fireAlarm;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean videoPhone;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean common_entrance;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean cctv;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean interPhone;

    public RoomOptionsDto(String building_name, boolean induction, boolean microwave, boolean airConditioner,
                          boolean tv, boolean bed, boolean desk, boolean shoeCloset, boolean gasRange,
                          boolean refrigerator, boolean doorLock, boolean fireAlarm, boolean videoPhone,
                          boolean common_entrance, boolean cctv, boolean interPhone){
        this.building_name = building_name;
        this.induction = induction;
        this.microwave = microwave;
        this.airConditioner = airConditioner;
        this.tv = tv;
        this.bed = bed;
        this.desk = desk;
        this.shoeCloset = shoeCloset;
        this.gasRange = gasRange;
        this.refrigerator = refrigerator;
        this.doorLock = doorLock;
        this.fireAlarm = fireAlarm;
        this.videoPhone = videoPhone;
        this.common_entrance = common_entrance;
        this.cctv = cctv;
        this.interPhone = interPhone;
    }
}
