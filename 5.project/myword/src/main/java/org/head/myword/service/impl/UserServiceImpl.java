package org.head.myword.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.head.myword.mapper.UserMapper;
import org.head.myword.model.domain.User;
import org.head.myword.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author headhead
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-07-07 17:10:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper userMapper;
    @Override
    public int findWordCountByUserId(Long userId) {
        return userMapper.selectWordCountByUserId(userId);
    }
}




