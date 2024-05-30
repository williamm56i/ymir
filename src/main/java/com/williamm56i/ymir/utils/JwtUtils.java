package com.williamm56i.ymir.utils;

import com.williamm56i.ymir.security.YmirUserDetails;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;

public class JwtUtils {

    private static final String TOKEN_SECRET = "123";
    private static Key secretKey;

    public static String generate(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Key secretKey = generalKey();
        JwtBuilder builder = Jwts.builder().signWith(secretKey, signatureAlgorithm).setSubject(username);
        return builder.compact();
    }

    public static boolean validateToken(String jwt) {
        // TODO 驗證時效性
        return true;
    }

    public static UserDetails parseJwt(String jwt) {
        Key secretKey = generalKey();
        String username = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody().getSubject();
        return new YmirUserDetails(username, null, null);
    }

    private static Key generalKey() {
        if (secretKey == null) {
            secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
        return secretKey;
    }
}
