package com.head.blog.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Map;

// Jwt 工具类
@Slf4j
public class JwtUtils {
    // 过期时间
    private static final long expiration = 30 * 60 * 1000;
    private static final String secretString = "gdfddshssdreshfhddddddddffffffffffffwwwwwwwwwnsoijhs";
    private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

    public static String getToken(Map<String,Object> claim){
        String token = Jwts.builder()
                .setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
        return token;
    }

    public static Claims parseToken(String token){
        if(token==null){
            return null;
        }
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = null;
        try{
            claims = build.parseClaimsJws(token).getBody();
        }catch (Exception e){
            log.error("解析token失败, token:" + token);
        }
        return claims;
    }

    public static Integer getUserIdFromToken(String token){
        Claims claims = parseToken(token);
        if(claims == null){
            return null;
        }
        return (Integer) claims.get("id");
    }

}
