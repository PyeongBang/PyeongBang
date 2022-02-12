package com.project.PyeongBang.service;

import com.project.PyeongBang.dto.*;

import java.util.List;

public interface RoomSvc {

    /** roomInfo 데이터 삽입 */
    public void addRoomInfo(RoomInfoDto roomInfoDto) throws Exception;

    /** roomDetails 데이터 삽입 */
    public void addRoomDetails(RoomDetailsDto roomDetailsDto) throws Exception;

    /** roomOptions 데이터 삽입 */
    public void addRoomOptions(RoomOptionsDto roomOptionsDto) throws Exception;

    /** 모든 방 매물 return */
    public List<RoomInfoDto> getAllRoomInfo() throws Exception;

    /** 매물 정보 return (roomInfo + roomDetails + roomOptions) */
    public DetailResponseDto selectRoomInfo (int num, int room_id, String major) throws Exception;

    /** 건물명으로 매물 검색 */
    public List<RoomInfoDto> selectBuildingNameInfo(String building_name) throws Exception;

    /** 주소로 매물 검색 */
    public List<RoomInfoDto> selectAddress(String address) throws Exception;

    /** 건물 옵션 조회 */
    public List<RoomOptionsDto> getRoomOptions(String building_name) throws Exception;
}
