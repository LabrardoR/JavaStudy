package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {
    // 查
    List<UserInfo> selectAll();
    // 增
    Integer insert(UserInfo userInfo);
    // 删
    Integer delete(Integer id);
    // 改
    Integer update(Integer id);
}
