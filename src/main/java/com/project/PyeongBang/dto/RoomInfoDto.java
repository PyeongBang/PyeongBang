package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RoomInfoDto {
    private int room_id; // 매물번호
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String realStates_phone;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String building_name;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String room_type;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String address;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String monthly_estimated_cost; // 한달 예상 주거비용
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String monthly; // 월세
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String administrative_expense; // 관리비
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String parking;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean short_term_rental; // 단기임대 /  0 불가, 1 가능

    public RoomInfoDto(int room_id, String realStates_phone, String building_name, String room_type,
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
