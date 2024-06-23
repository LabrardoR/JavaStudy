package com.head.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest{
    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;  //星球编号

}
