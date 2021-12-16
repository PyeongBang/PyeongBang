package com.project.PyeongBang.service;

import com.project.PyeongBang.dto.*;
import com.project.PyeongBang.mapper.RoomDetailsMapper;
import com.project.PyeongBang.mapper.RoomInfoMapper;
import com.project.PyeongBang.mapper.RoomOptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoomSvc {
    @Autowired
    private RoomDetailsMapper roomDetailsMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private RoomOptionsMapper roomOptionsMapper;

    private RoomOptionsDto roomOptionsDto;
    private RoomDetailsDto roomDetailsDto;
    private RoomInfoDto roomInfoDto;

    // roomInfo 추가
    public void addRoomInfo(@RequestBody RoomInfoDto roomInfoDto){
        roomInfoMapper.insertRoomInfo(roomInfoDto.getRoom_id(), roomInfoDto.getRealStates_phone(), roomInfoDto.getBuilding_name(),
                roomInfoDto.getRoom_type(), roomInfoDto.getAddress(), roomInfoDto.getMonthly_estimated_cost(),
                roomInfoDto.getMonthly(), roomInfoDto.getAdministrative_expense(), roomInfoDto.getParking(),
                roomInfoDto.isShort_term_rental());
    }

    // room details 추가
    public void addRoomDetails(@RequestBody RoomDetailsDto roomDetailsDto){
        roomDetailsMapper.insertRoomDetails(roomDetailsDto.getNum(), roomDetailsDto.getRoom_id(), roomDetailsDto.getFloor(),
                roomDetailsDto.getSize(), roomDetailsDto.getRoom_cnt(), roomDetailsDto.getHeating(), roomDetailsDto.getBuilt_in(),
                roomDetailsDto.getParking(), roomDetailsDto.isElevator(), roomDetailsDto.isBalcony(), roomDetailsDto.getMove_in_date(),
                roomDetailsDto.getApproved_date());
    }

    // room options 추가
    public void addRoomOptions(@RequestBody RoomOptionsDto roomOptionsDto){
        roomOptionsMapper.insertRoomOptions(roomOptionsDto.getBuilding_name(), roomOptionsDto.isInduction(), roomOptionsDto.isMicrowave(),
                roomOptionsDto.isAirConditioner(), roomOptionsDto.isTv(), roomOptionsDto.isBed(), roomOptionsDto.isDesk(),
                roomOptionsDto.isShoeCloset(), roomOptionsDto.isGasRange(), roomOptionsDto.isRefrigerator(), roomOptionsDto.isDoorLock(),
                roomOptionsDto.isFireAlarm(), roomOptionsDto.isVideoPhone(), roomOptionsDto.isCommon_entrance(),
                roomOptionsDto.isCctv(), roomOptionsDto.isInterPhone());
    }

    // 모든 매물 return
    public List<RoomInfoDto> getAllRoomInfo(){
        return roomInfoMapper.getAllRoomInfo();
    }

    // 매물 info + detail + options
    public DetailResponseDto selectRoomInfo(int num, int room_id){
        List<RoomInfoDto> roomInfoList = roomInfoMapper.getRoomInfo(room_id);
        List<RoomOptionsDto> roomOptionsList = roomOptionsMapper.getRoomOptions(roomInfoList.get(0).getBuilding_name());
        List<RoomDetailsDto> roomDetailsList = roomDetailsMapper.getRoomDetails(num, room_id);
        DetailBeforeDto detailBeforeDto = new DetailBeforeDto(roomInfoList.get(0), roomDetailsList.get(0), roomOptionsList.get(0));
        DetailResponseDto detailResponseDto = new DetailResponseDto(detailBeforeDto);
        return detailResponseDto;
    }

    // 건물 이름으로 검색
    public List<RoomInfoDto> selectBuildingNameInfo(String building_name){
        return roomInfoMapper.selectBuildingName(building_name);
    }

    // 주소로 매물 검색
    public List<RoomInfoDto> selectAddress(String address){
        return roomInfoMapper.selectAddress(address);
    }

    // 건물의 옵션 검색
    public List<RoomOptionsDto> getRoomOptions(String building_name){
        return roomOptionsMapper.getRoomOptions(building_name);
    }
}