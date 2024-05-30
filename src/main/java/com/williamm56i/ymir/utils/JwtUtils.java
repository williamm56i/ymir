package com.williamm56i.ymir.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;

@Slf4j
public class JwtUtils {

    private static Key secretKey;

    public static String generate(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Key secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .signWith(secretKey, signatureAlgorithm)
                .setSubject(username)
                .setExpiration(getExpireDate());
        return builder.compact();
    }

    public static String parseJwt(String jwt) {
        Key secretKey = generalKey();
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();
            return claims.getSubject();
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private static Key generalKey() {
        if (secretKey == null) {
            secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
        return secretKey;
    }

    private static Date getExpireDate() {
        long current = System.currentTimeMillis();
        long tokenExpireTime = 60 * 60 * 1000;
        long exp = current + tokenExpireTime;
        Date expireDate = new Date(exp);
        log.info("expireDate: " + expireDate);
        return expireDate;
    }
}
