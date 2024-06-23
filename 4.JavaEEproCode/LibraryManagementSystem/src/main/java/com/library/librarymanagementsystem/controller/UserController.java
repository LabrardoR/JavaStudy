package com.library.librarymanagementsystem.controller;

import com.library.librarymanagementsystem.model.UserInfo;
import com.library.librarymanagementsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        // 校验参数是否未空
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        // 验证账号密码是否正确
        // 常量写在前->开发习惯
        // 去数据库中验证账户密码
        UserInfo userInfo = userService.getUserInfo(userName);
        if(userInfo==null || userInfo.getId() <= 0){
            return false;
        }

        if(password.equals(userInfo.getPassword())){
            // 账户密码正确,存在session中
            userInfo.setPassword("");
            session.setAttribute("session_user_key",userInfo);
            return true;
        }

        return false;
    }
}
