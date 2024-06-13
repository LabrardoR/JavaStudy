package com.head.blog;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilTest {
    //过期时间: 30分钟
    private static final long expiration = 30 * 60 * 1000;
    private static final String secretString = "asafasafsafasfafsafsafafwwfsasgasagsagsagsasgasgasgasgsgafasgfa";
    private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
    // 1.生成token
    @Test
    public void getToken(){

        Map<String,Object> claim = new HashMap<>();
        claim.put("id",5);
        claim.put("name","zhangsan");
        String token = Jwts.builder()
                .setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(key)
                .compact();
        System.out.println(token);
    }

    @Test
    public void getKey(){
        // 随机生成一个key
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.ES384);
        String key = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(key);
    }
    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6NSwiZXhwIjoxNzE3NTUzODMwfQ.b9h68GvrNOcScXuACV7K2uryaF-FFJ6ih2U55yQ4emY";
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        build.parseClaimsJws(token).getBody();
    }

    // 2.验证token


}
