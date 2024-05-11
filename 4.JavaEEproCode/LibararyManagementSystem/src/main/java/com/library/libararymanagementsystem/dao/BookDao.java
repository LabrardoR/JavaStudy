package com.library.libararymanagementsystem.dao;

import com.library.libararymanagementsystem.model.BookInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDao {
    public List<BookInfo> mockData(){
        // 对于已知的数据量,或者大概知道这个集合的数据量时,指定初始化容量
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStatus(i%5 == 0 ? 1 : 0);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
