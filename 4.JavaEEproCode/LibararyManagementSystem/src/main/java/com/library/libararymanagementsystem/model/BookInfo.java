package com.library.libararymanagementsystem.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price; // 保证精度
    private String publish; // 出版社
    private Integer status; // 可借阅 不可借阅
    private String statusCN; // 状态的中文说明
}
