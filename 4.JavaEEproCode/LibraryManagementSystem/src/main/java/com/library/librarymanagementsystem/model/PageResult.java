package com.library.librarymanagementsystem.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private List<T> records; // 当前页的记录
    private Integer total; // 总记录数



    private PageRequest pageRequest;
    public PageResult (List<T> records,Integer total,PageRequest pageRequest){
        this.records = records;
        this.total = total;
        this.pageRequest = pageRequest;
    }

}
