package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.DetailResponseDto;
import com.project.PyeongBang.dto.RoomDetailsDto;
import com.project.PyeongBang.dto.RoomInfoDto;
import com.project.PyeongBang.dto.RoomOptionsDto;
import com.project.PyeongBang.service.RoomSvc;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController(value = "/saleinfo")
public class RoomManageController {

    @Autowired
    private final RoomSvc roomSvc;

    // add room info
    @ApiOperation(value="매물 정보 입력", notes ="부동산에서 방의 정보를 입력")
    @RequestMapping(value = "/postroominfo", method = RequestMethod.POST, produces = "application/json")
    public String addRoomInfo(@Valid @RequestBody RoomInfoDto roomInfoDto, BindingResult bindingResult) throws Exception{
        /** common class RoomInfo validation check **/
        /*
        new RoomInfoValidator().validate(roomInfoDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }else{
            roomSvc.addRoomInfo(roomInfoDto);
        }
         */

        /** hibernate validation check**/
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getField();
        }else{
            roomSvc.addRoomInfo((roomInfoDto));
        }
        return "추가 완료";
    }

    // add room details
    @ApiOperation(value="매물 세부 정보를 입력", notes="부동산에서 방의 세부정보를 입력")
    @RequestMapping(value = "/roomdetails", method = RequestMethod.POST, produces = "application/json")
    public String addRoomDetails(@Valid @RequestBody RoomDetailsDto roomDetailsDto, BindingResult bindingResult) throws Exception{
        /** common class RoomInfo validation check **/
        /*
        new RoomDetailsValidator().validate(roomDetailsDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        }else{
            roomSvc.addRoomDetails(roomDetailsDto);
        }*/

        /** hibernate validation check**/
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getField();
        }else{
            roomSvc.addRoomDetails(roomDetailsDto);
        }

        return "추가 완료";
    }

    // add room options
    @ApiOperation(value="매물 옵션을 입력", notes="부동산에서 방의 옵션을 입력")
    @RequestMapping(value = "/roomOptions", method = RequestMethod.POST, produces = "application/json")
    public String addRoomOptions(@RequestBody RoomOptionsDto roomOptionsDto, BindingResult bindingResult) throws Exception{
        /** common class RoomInfo validation check **/
        /*
        new RoomOptionsValidator().validate(roomOptionsDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors).toString();
        } else{
            roomSvc.addRoomOptions(roomOptionsDto);
        }
         */
        /** hibernate validation check**/
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getField();
        }else{
            roomSvc.addRoomOptions(roomOptionsDto);
        }
        return "추가 완료";
    }

    // 원하는 방 선택 시 info, detail, option 합쳐서 return
    @ApiOperation(value="선택한 매물의 정보를 리턴", notes="방의 정보 + 디테일 + 옵션에 대한 모든 값")
    @GetMapping("/responseInfo")
    public DetailResponseDto selectRoomInfo(HttpServletRequest httpServletRequest) throws Exception{
        int num = Integer.parseInt(httpServletRequest.getParameter("num"));
        int room_id = Integer.parseInt(httpServletRequest.getParameter("room_id"));
        String major = httpServletRequest.getParameter("major");
        return roomSvc.selectRoomInfo(num, room_id, major);
    }

    // 빌딩 이름으로 검색
    @ApiOperation(value="빌딩 이름으로 검색", notes="빌딩 이름으로 매물 검색")
    @GetMapping("/searchBuildingName")
    public List<RoomInfoDto> selectBuildingName(HttpServletRequest httpServletRequest) throws Exception{
        String building_name = httpServletRequest.getParameter("building_name");
        return roomSvc.selectBuildingNameInfo(building_name);
    }

    // 주소로 검색
    @ApiOperation(value="주소로 방 검색", notes="주소를 활용한 매물 검색")
    @GetMapping("/searchAddress")
    public List<RoomInfoDto> selectAddress(HttpServletRequest httpServletRequest) throws Exception{
        String address = httpServletRequest.getParameter("address");
        return roomSvc.selectAddress(address);
    }
}
