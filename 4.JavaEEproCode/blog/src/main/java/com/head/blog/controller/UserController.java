package com.head.blog.controller;

import com.head.blog.model.Result;
import com.head.blog.model.UserInfo;
import com.head.blog.service.UserService;
import com.head.blog.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(String userName,String password){
        // 1.参数校验
        // 2.密码校验
        // 3.生成token,并返回

        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return Result.fail("用户名或密码为空");
        }
        // 获取数据库中的密码
        UserInfo userInfo = userService.queryByName(userName);
        if(userInfo == null || userInfo.getId() < 0){
            return Result.fail("用户不存在");
        }
        if(!password.equals(userInfo.getPassword())){
            return Result.fail("密码错误!");
        }
        //密码正确,生成token并返回
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", userInfo.getId());
        claim.put("name",userInfo.getUserName());
        String token = JwtUtils.getToken(claim);
        return Result.success(token);
    }

    // 获取用户的登录信息
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request){
        // 1. 从token中获取用户ID
        // 2. 根据用户ID,获取用户信息
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        if(userId == null){
            return null;
        }
        return userService.queryById(userId);
    }

    // 获取当前作者信息
    @RequestMapping("/getAuthorInfo")
    public UserInfo getAuthorInfo(Integer blogId){
        //1. 根据blogId 获取userId
        //2. 根据userId 获取userInfo
        if(blogId == null || blogId < 0){
            return null;
        }
        return userService.getAuthorInfo(blogId);
    }
}
