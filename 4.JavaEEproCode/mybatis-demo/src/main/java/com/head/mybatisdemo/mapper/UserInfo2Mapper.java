package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 注解与 xml 方式可以共存
@Mapper
public interface UserInfo2Mapper {
    //增
    @Insert("<script>insert into userinfo(username,password,age," +
            "<if test='gender!=null'> " +
            "gender, " +
            "</if>" +
            "phone)" +
            "values (#{username},#{password},#{age}," +
            "<if test='gender!=null'>#{gender},</if>" +
            "#{phone})" +
            "</script>")
    void insert(UserInfo userInfo);

    Integer insertByXML(UserInfo userInfo);

    // 以xml实现
    // 查
    List<UserInfo> selectByCondition(UserInfo userInfo);
    // 改
    Integer updateByCondition(UserInfo userInfo);
    // 删
    Integer deleteByCondition(UserInfo userInfo);

    Integer batchDelete(List<Integer> ids);

}
