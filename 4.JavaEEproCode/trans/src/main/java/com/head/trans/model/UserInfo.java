package com.head.trans.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private String userName;
    private String password;
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private  String op;
}
