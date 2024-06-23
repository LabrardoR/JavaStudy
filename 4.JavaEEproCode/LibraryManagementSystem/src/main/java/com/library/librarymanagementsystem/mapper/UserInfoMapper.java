package com.library.librarymanagementsystem.mapper;

import com.library.librarymanagementsystem.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name=#{name}")
    public UserInfo getSelectByName(String name);

}
