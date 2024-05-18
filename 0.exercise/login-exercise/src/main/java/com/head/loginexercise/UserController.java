package com.head.loginexercise;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/getUserInfo")
    public Boolean getUserInfo(String username, String password){
        if("root".equals(username) && "root".equals(password)){
            return true;
        }
        return false;
    }
}
