package com.head.blog.service;

import com.head.blog.mapper.BlogInfoMapper;
import com.head.blog.mapper.UserInfoMapper;
import com.head.blog.model.BlogInfo;
import com.head.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogInfoMapper blogInfoMapper;
    public UserInfo queryByName(String userName) {
        return userInfoMapper.queryByName(userName);
    }

    public UserInfo queryById(Integer userId) {
        return userInfoMapper.queryById(userId);
    }

    public UserInfo getAuthorInfo(Integer blogId) {
        // 1. 根据blogId,获取userId
        // 2. 根据userId,获取userInfo
        BlogInfo blogInfo = blogInfoMapper.queryById(blogId);
        if(blogInfo==null || blogInfo.getUserId()<0){
            return null;
        }
        Integer userId = blogInfo.getUserId();
        return userInfoMapper.queryById(userId);
    }
}
