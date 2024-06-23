package com.head.usercenter.mapper;
import java.util.Date;

import com.head.usercenter.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println("测试开始");

        User user = new User();
        user.setId(0L);
        user.setUserName("");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserAccount("");
        user.setUserPassword("");
        user.setPhone("");
        user.setEmail("");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        System.out.println("测试结束");
    }
    @Test
    public void selectAll(){

    }


}