package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NotEmpty
@ApiModel(value = "매물 옵션", description = "빌딩 이름을 기준으로 매물 옵션 정보")
public class RoomOptionsDto {
    @ApiModelProperty(example = "매물 건물 이름")
    private String building_name; // 건물명
    private boolean induction;
    private boolean microwave;
    private boolean airConditioner;
    private boolean tv;
    private boolean bed;
    private boolean desk;
    private boolean shoeCloset;
    private boolean gasRange;
    private boolean refrigerator;
    private boolean doorLock;
    private boolean fireAlarm;
    private boolean videoPhone;
    private boolean common_entrance;
    private boolean cctv;
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
