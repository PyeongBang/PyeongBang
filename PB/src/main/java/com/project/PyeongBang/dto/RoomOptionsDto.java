package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomOptionsDto {
    private String name; // 건물명
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
    public RoomOptionsDto(String name, boolean induction, boolean microwave, boolean airConditioner,
                          boolean tv, boolean bed, boolean desk, boolean shoeCloset, boolean gasRange,
                          boolean refrigerator, boolean doorLock){
        this.name = name;
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
    }
}
