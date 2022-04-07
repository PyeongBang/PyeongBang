package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NotEmpty(message = "필수 값을 모두 입력해주세요")
@ApiModel(value = "부동산 정보")
public class RealStatesDto {
    @ApiModelProperty(example = "부동산 연락처")
    private String phone;
    private String user_id;
    @ApiModelProperty(example = "부동산 관리자 이름")
    private String name;
    @ApiModelProperty(example = "부동산 주소")
    private String address;
    public RealStatesDto(String phone, String user_id, String name, String address){
        this.phone = phone;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
    }
}
