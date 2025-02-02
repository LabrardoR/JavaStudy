package com.head.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into user_info (user_name,password) values (#{userName}, #{password})")
    Integer insert(String userName, String password);


}
