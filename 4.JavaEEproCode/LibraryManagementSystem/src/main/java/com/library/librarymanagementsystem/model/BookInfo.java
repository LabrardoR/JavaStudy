package com.library.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price; // 保证精度
    private String publish; // 出版社
    private Integer status; // 1-可借阅 2-不可借阅
    private String statusCN; // 状态的中文说明
}
