package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomInfo {
    private int room_id;
    private String realStates_phone;
    private String building_name;
    private String room_type;
    private String address;
    private String monthly_estimated_cost;
    private String monthly; // 월세
    private String administrative_expense;
    private String parking;
    private boolean short_term_rental;

    public RoomInfo(int room_id, String realStates_phone, String building_name, String room_type,
                    String address, String monthly_estimated_cost, String monthly, String administrative_expense,
                    String parking, boolean short_term_rental){
        this.room_id = room_id;
        this.realStates_phone = realStates_phone;
        this.building_name = building_name;
        this.room_type = room_type;
        this.address = address;
        this.monthly_estimated_cost = monthly_estimated_cost;
        this.monthly= monthly;
        this.administrative_expense = administrative_expense;
        this.parking = parking;
        this.short_term_rental = short_term_rental;
    }
}
