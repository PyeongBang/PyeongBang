package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NotEmpty
@ApiModel(value = "매물 정보")
public class RoomInfoDto {
    @ApiModelProperty(example = "매물 고유번호")
    private int room_id; // 매물번호
    private String realStates_phone;
    private String building_name;
    private String room_type;
    private String address;
    @ApiModelProperty(example = "한달 예상 주거비용")
    private String monthly_estimated_cost; // 한달 예상 주거비용
    @ApiModelProperty(example = "월세")
    private String monthly; // 월세
    @ApiModelProperty(example = "관리비")
    private String administrative_expense; // 관리비
    private String parking;
    @ApiModelProperty(example = "단기 임대 여부")
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
