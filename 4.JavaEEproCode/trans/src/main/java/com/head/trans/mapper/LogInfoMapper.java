package com.head.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogInfoMapper {
    @Insert("insert into log_info (user_name, op) values (#{userName}, #{op})")
    Integer insert(String userName, String op);

}
