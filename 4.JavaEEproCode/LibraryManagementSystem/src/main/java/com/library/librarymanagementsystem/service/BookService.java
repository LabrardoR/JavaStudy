package com.library.librarymanagementsystem.service;

import com.library.librarymanagementsystem.enums.BookStatusEnum;
import com.library.librarymanagementsystem.mapper.BookInfoMapper;
import com.library.librarymanagementsystem.model.BookInfo;
import com.library.librarymanagementsystem.model.PageRequest;
import com.library.librarymanagementsystem.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    // 对来自 BookInfoMapper 的数据进行处理. 处理后将数据交给 BookController
    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest){
        if(pageRequest==null){
            return null;
        }
        Integer count = bookInfoMapper.count();
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoByPage(pageRequest.getOffset(),pageRequest.getPageSize());
        if (bookInfos != null && !bookInfos.isEmpty()){
            for (BookInfo bookInfo : bookInfos){
                // 根据status 获取状态的定义
                bookInfo.setStatusCN(BookStatusEnum.getNameByCode(bookInfo.getStatus()).getName());
            }
        }

        return new PageResult<>(bookInfos,count,pageRequest);
    }

    public Integer addBook(BookInfo bookInfo){
        Integer result = null;
        try{
            result = bookInfoMapper.insertBook(bookInfo);
            if(result <= 0){
                // 打印 bookInfo 参数信息
                log.error("添加图书出错,:bookInfo:{}",bookInfo);
            }
        }catch (Exception e){
            log.error("添加图书出错,e:{}",e);
        }
        return result;
    }

    public BookInfo queryBookInFoById(Integer id){
        BookInfo bookInfo = null;
        try{
            bookInfo = bookInfoMapper.selectBookById(id);
        }catch(Exception e){
            log.error("根据id查询图书出错,e:{}",e);
        }

        return bookInfo;
    }

    public BookInfo queryBookInfoByName(String name){
        if(name==null){
            log.error("name参数有误!");
        }
        BookInfo bookInfo = null;
        try{
            bookInfo = bookInfoMapper.selectBookByName(name);
        }catch(Exception e){
            log.error("name查询失败!");
        }
        return bookInfo;
    }

    public Integer updateBook (BookInfo bookInfo){
        Integer result = 0;
        try{
            result = bookInfoMapper.updateBook(bookInfo);
        }catch (Exception e){
            log.error("更新图书失败,e:{}",e);
        }
        return result;
    }

    public Integer batchDelete(List<Integer> ids){
        Integer result = 0;
        try{
            result = bookInfoMapper.batchDelete(ids);
        }catch (Exception e){
            log.error("批量删除图书失败, ids:{}",ids);
        }
        return result;
    }

}
