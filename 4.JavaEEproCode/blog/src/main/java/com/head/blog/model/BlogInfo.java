package com.head.blog.model;

import com.head.blog.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    private boolean isLoginUser;


    public String getCreateTime(){
        return DateUtils.formatDate(createTime);
    }
}
