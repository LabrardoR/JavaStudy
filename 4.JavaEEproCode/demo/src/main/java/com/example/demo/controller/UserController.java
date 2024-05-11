package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        /*
        if(userName == null || userName.isEmpty() || password == null || password.isEmpty()){
            return false;
        }
         */
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        if("admin".equals(userName) && "admin".equals(password)){
            //设置 Session
            session.setAttribute("userName","admin");
            return true;
        }
        return false;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session){
        return (String) session.getAttribute("userName");
    }
}
