package com.head.mybatisdemo.mapper;


import com.head.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    // 查
    @Select("select * from userinfo")
    List<UserInfo> selectAll();

    // 查
    @Results(id = "BaseMap", value = {
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    @Select("select * from userinfo")
    List<UserInfo> selectAll2();

    @ResultMap(value = "BaseMap")
    @Select("select * from userinfo where id= #{id}")
    UserInfo selectOne(Integer id);

    @Select("select * from userinfo where id= #{userId}")
    UserInfo selectOne2(@Param("userId") Integer Id);

    // 返回自增ID
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, password, age, gender, phone)"+
    "values(#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    // 对Insert的参数进行重命名
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, password, age, gender, phone)"+
            "values(#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    // 删
    @Delete("delete from userinfo where id=#{id}")
    Integer delete(Integer id);

    // 改
    @Update("update userinfo set age=#{age} where id=#{id}")
    Integer update(UserInfo userInfo);

    // 排序时, 不能使用 # : 会给字符加上'', 只能使用 $
    @Select("select * from userinfo order by id ${sort}")
    List<UserInfo> selectUserBySort(String sort);

    @Select("select * from userinfo where username like '%${username}%'")
    List<UserInfo> selectUserByLike(String username);
}
