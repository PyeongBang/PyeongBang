package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoomDetailsDto {
    @NotEmpty(message = "필수 값을 입력해주세요")
    private int num;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private int room_id; // 매물 번호
    @NotEmpty(message = "필수 값을 입력해주세요")
    private int floor; // 층수
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String size; // 방 크기
    @NotEmpty(message = "필수 값을 입력해주세요")
    private int room_cnt; // 방 개수
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String heating; // 난방 방법
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String built_in;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private int parking; // 주차 공간 개수
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean elevator;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private boolean balcony;
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String move_in_date; // 입주 날짜
    @NotEmpty(message = "필수 값을 입력해주세요")
    private String approved_date; // 승인 날짜

    public RoomDetailsDto(int num, int room_id, int floor, String size, int room_cnt, String heating,
                          String built_in, int parking, boolean elevator, boolean balcony,
                          String move_in_date, String approved_date){
        this.num = num;
        this.room_id = room_id;
        this.floor = floor;
        this.size = size;
        this.room_cnt = room_cnt;
        this.heating = heating;
        this.built_in = built_in;
        this.parking = parking;
        this.elevator = elevator;
        this.balcony = balcony;
        this.move_in_date = move_in_date;
        this.approved_date = approved_date;
    }
}
