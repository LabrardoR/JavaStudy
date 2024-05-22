package com.library.librarymanagementsystem.model;


import lombok.Data;

@Data
public class PageRequest {
    private Integer currentPage = 1;// 当前页码
    private Integer pageSize = 10; // 每页显示条数
    private Integer offset;
    public Integer getOffset(){
        return (currentPage - 1) * pageSize;
    }
}
