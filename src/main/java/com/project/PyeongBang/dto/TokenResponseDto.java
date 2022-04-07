package com.project.PyeongBang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "JWT 토큰", description = "로그인 시 발급되는 토큰, 부동산 관리자 한정")
public class TokenResponseDto {
    @ApiModelProperty(example = "발급된 토큰")
    private String accessToken;
    @ApiModelProperty(example = "토큰 유형")
    private String tokenType;

    public TokenResponseDto(String accessToken, String tokenType){
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
}
