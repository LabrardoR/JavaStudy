package com.head.blog.config;

import com.head.blog.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 进行用户登录校验
        // 1.从header中获取token
        // 2.验证token
        String token = request.getHeader("user_token"); //约定前端发送请求时,header中发送一个user_token的值
        log.info("从header中获取token:" + token);
        Claims claims = JwtUtils.parseToken(token);
        if(claims == null){
            response.setStatus(401); // 需要登录
            return false;
        }
        return true;
    }
}
