package com.head.mybatisdemo.controller;

import com.head.mybatisdemo.mapper.UserInfoMapper;
import com.head.mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll(){
        return userInfoMapper.selectAll();
    }
}
