package com.example.demo.controller;

import lombok.*;

import java.util.Date;

@Data // 组合注解: 包括 @Getter @Setter @ToString @EqualsAndHashCode
public class MessageInfo {
    private String from;
    private String to;
    private String message;
    private Date CreateTime;
}
