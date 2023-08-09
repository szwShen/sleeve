package com.szw.missyou.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 13:39
 * @Description: com.szw.missyou.utils
 * @version: 1.0
 */
@Component
public class Jwt {
    private static String jwtKey;
    private static Integer expireTime;
    private static Integer defaultScope = 9;

    @Value("${missyou.security.jwt-key}")
    public static void setJwtKey(String jwtKey) {
        Jwt.jwtKey = jwtKey;
    }

    @Value("${missyou.security.token-expired-in}")
    public static void setExpireTime(Integer expireTime) {
        Jwt.expireTime = expireTime;
    }

    public static String makeToken(Long uid) {
        return Jwt.getToken(uid, Jwt.defaultScope);
    }

    public static String makeToken(Long uid, Integer scope) {
        return getToken(uid, scope);
    }

    public static Optional<Map<String, Claim>> getClaim(String token) {
        DecodedJWT verify;
        Algorithm algorithm = Algorithm.HMAC256(Jwt.jwtKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        try {
            verify = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(verify.getClaims());
    }

    // autho
    public static String getToken(Long uid, Integer socpe) {

        Algorithm algorithm = Algorithm.HMAC256(Jwt.jwtKey);
        Map<String, Date> caulal = Jwt.caulal();

        String sign = JWT.create()
                .withClaim("uid", uid)
                .withClaim("scope", socpe)
                .withExpiresAt(caulal.get("expireTime"))
                .withIssuedAt(caulal.get("now"))
                .sign(algorithm);

        return sign;
    }

    private static Map<String, Date> caulal() {
        HashMap<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, Jwt.expireTime);
        map.put("now", now);
        map.put("expireTime", calendar.getTime());
        return map;


    }
}
