package com.head.trans.service;

import com.head.trans.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public Integer insertUser(String userName, String password){
        return userInfoMapper.insert(userName, password);
    }
}
