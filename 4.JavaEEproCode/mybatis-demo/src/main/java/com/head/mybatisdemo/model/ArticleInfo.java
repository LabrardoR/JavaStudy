package com.head.mybatisdemo.model;

import lombok.Data;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Data
public class ArticleInfo {
    // 文章相关信息
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    // 用户相关信息
    private String username;
    private Integer age;
}
