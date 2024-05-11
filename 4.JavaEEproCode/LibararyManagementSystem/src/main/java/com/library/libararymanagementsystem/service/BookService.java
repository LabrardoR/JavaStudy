package com.library.libararymanagementsystem.service;

import com.library.libararymanagementsystem.dao.BookDao;
import com.library.libararymanagementsystem.model.BookInfo;

import java.util.List;

public class BookService {
    private final BookDao bookDao = new BookDao();
    public List<BookInfo> getBookList(){

        // mock 表示虚拟的,假数据
        List<BookInfo> bookInfos = bookDao.mockData();
        for(BookInfo bookInfo: bookInfos){
            if (bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
