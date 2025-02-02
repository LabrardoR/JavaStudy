package com.head.blog.mapper;

import com.head.blog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    // 根据用户名,查询用户信息
    @Select("select * from user where user_name=#{userName} and delete_flag=0")
    UserInfo queryByName(String userName);

    // 根据用户ID,查询用户信息
    @Select("select * from user where id=#{id} and delete_flag=0")
    UserInfo queryById(Integer id);
}
