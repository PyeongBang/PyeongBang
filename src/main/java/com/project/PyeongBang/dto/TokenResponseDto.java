package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
    private String accessToken;
    private String tokenType;

    public TokenResponseDto(String accessToken, String tokenType){
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
}
