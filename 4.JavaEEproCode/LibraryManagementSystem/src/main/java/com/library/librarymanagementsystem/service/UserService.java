package com.library.librarymanagementsystem.service;

import com.library.librarymanagementsystem.mapper.UserInfoMapper;
import com.library.librarymanagementsystem.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo(String name) {
        return userInfoMapper.getSelectByName(name);
    }


}
