package com.project.PyeongBang.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NotEmpty
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(value = "매물 관련 모든 정보", description = "매물과 관련된 모든 정보, 사용자에게 Return 해주기 위한 Model")
public class DetailResponseDto {
    private int room_id; // 매물번호
    private String realStates_phone;
    private String building_name;
    private String room_type;
    private String address;
    private String monthly_estimated_cost; // 한달 예상 주거비용
    private String monthly; // 월세
    private String administrative_expense; // 관리비
    private boolean short_term_rental; // 단기임대

    private int num;
    private int floor; // 층수
    private String size; // 방 크기
    private int room_cnt; // 방 개수
    private String heating; // 난방 방법
    private String built_in;
    private int parking; // 주차 공간 개수
    private boolean elevator;
    private boolean balcony;
    private String move_in_date; // 입주 날짜
    private String approved_date; // 승인 날짜

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

    private String distance;

    public DetailResponseDto(DetailBeforeDto detailBeforeDto){
        this.room_id = detailBeforeDto.getInfo().getRoom_id();
        this.realStates_phone = detailBeforeDto.getInfo().getRealStates_phone();
        this.building_name = detailBeforeDto.getInfo().getBuilding_name();
        this.room_type = detailBeforeDto.getInfo().getRoom_type();
        this.address = detailBeforeDto.getInfo().getAddress();
        this.monthly_estimated_cost = detailBeforeDto.getInfo().getMonthly_estimated_cost();
        this.monthly = detailBeforeDto.getInfo().getMonthly();
        this.administrative_expense = detailBeforeDto.getInfo().getAdministrative_expense();
        this.short_term_rental = detailBeforeDto.getInfo().isShort_term_rental();

        this.num = detailBeforeDto.getDetails().getNum();
        this.floor = detailBeforeDto.getDetails().getFloor();
        this.size = detailBeforeDto.getDetails().getSize();
        this.room_cnt = detailBeforeDto.getDetails().getRoom_cnt();
        this.heating = detailBeforeDto.getDetails().getHeating();
        this.built_in = detailBeforeDto.getDetails().getBuilt_in();
        this.parking = detailBeforeDto.getDetails().getParking();
        this.elevator = detailBeforeDto.getDetails().isElevator();
        this.balcony = detailBeforeDto.getDetails().isBalcony();
        this.move_in_date = detailBeforeDto.getDetails().getMove_in_date();
        this.approved_date = detailBeforeDto.getDetails().getApproved_date();

        this.induction = detailBeforeDto.getOptions().isInduction();
        this.microwave = detailBeforeDto.getOptions().isMicrowave();
        this.airConditioner = detailBeforeDto.getOptions().isAirConditioner();
        this.tv = detailBeforeDto.getOptions().isTv();
        this.bed = detailBeforeDto.getOptions().isBed();
        this.desk = detailBeforeDto.getOptions().isDesk();
        this.shoeCloset = detailBeforeDto.getOptions().isShoeCloset();
        this.gasRange = detailBeforeDto.getOptions().isGasRange();
        this.refrigerator = detailBeforeDto.getOptions().isRefrigerator();
        this.doorLock = detailBeforeDto.getOptions().isDoorLock();
        this.fireAlarm = detailBeforeDto.getOptions().isFireAlarm();
        this.videoPhone = detailBeforeDto.getOptions().isVideoPhone();
        this.common_entrance = detailBeforeDto.getOptions().isCommon_entrance();
        this.cctv = detailBeforeDto.getOptions().isCctv();
        this.interPhone = detailBeforeDto.getOptions().isInterPhone();

        this.distance = detailBeforeDto.getDistance();
    }
}
