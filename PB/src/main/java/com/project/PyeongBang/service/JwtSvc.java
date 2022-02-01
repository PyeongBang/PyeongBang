package com.project.PyeongBang.service;

public interface JwtSvc {

    public String createJwt(String id, String pwd) throws Exception;

    public boolean checkJwt(String jwt) throws Exception;
}
