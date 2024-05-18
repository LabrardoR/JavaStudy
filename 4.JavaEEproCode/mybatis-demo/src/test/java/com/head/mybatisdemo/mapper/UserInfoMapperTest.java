package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void selectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }


    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(1).toString());
    }

    @Test
    void selectOne2() {
        log.info(userInfoMapper.selectOne2(3).toString());
    }

    //@Test
    void insert() {
        UserInfo userInfo =new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("123456789");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 方法, 执行结果: {}, 自增ID:{}", result,userInfo.getId());
    }

    @Test
    void delete() {
        userInfoMapper.delete(11);
    }


    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);
        userInfo.setId(13);
        Integer result = userInfoMapper.update(userInfo);
        if (result > 0){
            System.out.println("数据修改成功");
        }
    }

    @Test
    void selectUserBySort() {
        List<UserInfo> list = userInfoMapper.selectUserBySort("desc");
        log.info(list.toString());
    }

    @Test
    void selectUserByLike() {
        log.info(userInfoMapper.selectUserByLike("zhaoliu").toString());
    }
}