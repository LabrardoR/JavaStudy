package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoXMLMapperTest {
    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;
    @Test
    void selectAll() {
        List<UserInfo> list = userInfoXMLMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void insert() {
        UserInfo userInfo =new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("123456789");

        Integer result = userInfoXMLMapper.insert(userInfo);
        log.info("insert 方法, 执行结果: {}, 自增ID:{}", result,userInfo.getId());
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}