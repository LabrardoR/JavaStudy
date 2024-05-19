package com.example.demo.model;

import lombok.*;

import java.util.Date;

@Data // 组合注解: 包括 @Getter @Setter @ToString @EqualsAndHashCode
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Date CreateTime;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
