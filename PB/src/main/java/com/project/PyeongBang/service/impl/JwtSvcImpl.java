package com.project.PyeongBang.service.impl;

import com.project.PyeongBang.service.JwtSvc;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSvcImpl implements JwtSvc {
    /** secret key 지정 */
    private String secretKey = "doneBaekFirstJwt";
    private Logger logger = LoggerFactory.getLogger(JwtSvcImpl.class);

    /** JWT 토큰 생성 */
    public String createJwt(String id, String pwd) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();

        // 토큰 만료기간 (1000ms = 1s) >> 1000 * 60(s) * 60(m) = 총 60분
        expireTime.setTime(expireTime.getTime() * 1000 * 60 * 60);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("type", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("pwd", pwd);

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

}
