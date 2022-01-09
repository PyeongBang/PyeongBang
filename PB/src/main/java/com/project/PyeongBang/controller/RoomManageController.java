package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.DetailResponseDto;
import com.project.PyeongBang.dto.RoomDetailsDto;
import com.project.PyeongBang.dto.RoomInfoDto;
import com.project.PyeongBang.dto.RoomOptionsDto;
import com.project.PyeongBang.dto.validation.RoomDetailsValidator;
import com.project.PyeongBang.dto.validation.RoomInfoValidator;
import com.project.PyeongBang.dto.validation.RoomOptionsValidator;
import com.project.PyeongBang.service.RoomSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomManageController {
    private final RoomSvc roomSvc;

    // add room info
    @RequestMapping(value = "/postroominfo", method = RequestMethod.POST, produces = "application/json")
    public String addRoomInfo(@RequestBody RoomInfoDto roomInfoDto, Errors errors) {
        // RoomInfo validation check
        new RoomInfoValidator().validate(roomInfoDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }else{
            roomSvc.addRoomInfo(roomInfoDto);
        }
        return "추가 완료";
    }

    // add room details
    @RequestMapping(value = "/roomdetails", method = RequestMethod.POST, produces = "application/json")
    public String addRoomDetails(@RequestBody RoomDetailsDto roomDetailsDto, Errors errors) {
        // RoomDetails validation check
        new RoomDetailsValidator().validate(roomDetailsDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }else{
            roomSvc.addRoomDetails(roomDetailsDto);
        }
        return "추가 완료";
    }

    // add room options
    @RequestMapping(value = "/roomOptions", method = RequestMethod.POST, produces = "application/json")
    public String addRoomOptions(@RequestBody RoomOptionsDto roomOptionsDto, Errors errors) {
        // RoomOptions validation check
        new RoomOptionsValidator().validate(roomOptionsDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        } else{
            roomSvc.addRoomOptions(roomOptionsDto);
        }
        return "추가 완료";
    }

    // 원하는 방 선택 시 info, detail, option 합쳐서 return
    @PostMapping("/responseInfo")
    public DetailResponseDto selectRoomInfo(HttpServletRequest httpServletRequest){
        int num = Integer.parseInt(httpServletRequest.getParameter("num"));
        int room_id = Integer.parseInt(httpServletRequest.getParameter("room_id"));
        String major = httpServletRequest.getParameter("major");
        return roomSvc.selectRoomInfo(num, room_id, major);
    }

    // 빌딩 이름으로 검색
    @PostMapping("/searchBuildingName")
    public List<RoomInfoDto> selectBuildingName(HttpServletRequest httpServletRequest){
        String building_name = httpServletRequest.getParameter("building_name");
        return roomSvc.selectBuildingNameInfo(building_name);
    }

    // 주소로 검색
    @PostMapping("/searchAddress")
    public List<RoomInfoDto> selectAddress(HttpServletRequest httpServletRequest){
        String address = httpServletRequest.getParameter("address");
        return roomSvc.selectAddress(address);
    }
}
