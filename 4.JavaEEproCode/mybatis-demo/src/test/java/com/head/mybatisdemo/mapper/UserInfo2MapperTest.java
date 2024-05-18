package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfo2MapperTest {
    @Autowired
    private UserInfo2Mapper userInfo2Mapper;
    //@Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wang");
        userInfo.setPassword("99812");
        userInfo.setAge(21);
        //userInfo.setGender(1);
        userInfo.setPhone("514514");
        userInfo2Mapper.insert(userInfo);
    }

    //@Test
    void insertByXML() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sssswang");
        userInfo.setPassword("19626");
        userInfo.setAge(26);
        userInfo.setGender(1);
        userInfo.setPhone("5144");
        userInfo2Mapper.insertByXML(userInfo);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        //userInfo.setUsername("wang");
        //userInfo.setAge(21);
        //userInfo.setGender(1);
        log.info(userInfo2Mapper.selectByCondition(userInfo).toString());
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        //userInfo.setUsername("head");
        userInfo.setAge(8);
        userInfo.setGender(2);
        userInfo.setPassword("11111111");
        //userInfo.setPhone("232424");
        log.info(userInfo2Mapper.updateByCondition(userInfo).toString());
    }

    @Test
    void batchDelete() {
        List<Integer> list = new ArrayList<>();
        userInfo2Mapper.batchDelete(Arrays.asList(30,31,32,33));

    }
}