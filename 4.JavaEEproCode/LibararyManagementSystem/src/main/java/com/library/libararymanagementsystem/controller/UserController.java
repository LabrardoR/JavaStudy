package com.library.libararymanagementsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        // 校验参数
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        // 验证账号密码是否正确
        // 常量写在前->开发习惯
        if ("admin".equals(userName) && "admin".equals(password)){
            // 账户密码正确,存在session中
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
}
