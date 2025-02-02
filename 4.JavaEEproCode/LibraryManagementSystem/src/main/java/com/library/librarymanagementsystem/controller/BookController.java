package com.library.librarymanagementsystem.controller;

import com.library.librarymanagementsystem.constant.Constants;
import com.library.librarymanagementsystem.enums.ResultCode;
import com.library.librarymanagementsystem.model.*;
import com.library.librarymanagementsystem.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
   private BookService bookService;


    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session){
        log.info("查询翻页信息,pageRequest:{}",pageRequest);
        // 用户登录校验
        UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo == null || userInfo.getId() <=0 || "".equals(userInfo.getUserName())){
            // 用户未登录
            return Result.unLogin();
        }
        if(pageRequest.getPageSize()<0 || pageRequest.getCurrentPage() < 1){
            return Result.fail("参数校验失败");
        }

        PageResult<BookInfo> bookInfoPageResult = null;
        try{
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
            return Result.success(bookInfoPageResult);

        }catch(Exception e){
            log.error("查询翻页信息错误,e{}",e);
            return Result.fail(e.getMessage());
        }

    }

    @RequestMapping(value = "/addBook",produces = "application/json")
    public String addBook(BookInfo bookInfo){
        log.info("接收到添加图书请求,bookInfo:{}",bookInfo);
        // 参数校验
        if (       !StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() < 0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())){
            return "参数校验失败";
        }
        Integer result = bookService.addBook(bookInfo);
        if( result <= 0 ){
            log.error("添加图书出错:bookInfo:{}",bookInfo);
            return "添加图书出错.请联系管理员";
        }
        return "";
    }

    @RequestMapping("/queryBookInfoById")
    public BookInfo queryBookInFoById(Integer id){
        log.info("根据ID查询图书,bookId:"+ id);

        if(id == null || id <= 0){
            log.error("id 参数校验失败,id:{}",id);
            return null;
        }

        return bookService.queryBookInFoById(id);
    }

    @RequestMapping(value = "/updateBook",produces = "application/json")
    public String updateBook(BookInfo bookInfo){
        log.info("接收到更新图书的请求, bookInfo:{}",bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if(result == 0){
            log.error("更新图书失败");
            return "更新图书失败,请联系管理员";
        }
        return "";// 表示成功
    }

    @RequestMapping(value = "/batchDelete",produces = "application/json")
    public String batchDelete(@RequestParam List<Integer> ids){
        log.info("接收请求，批量删除图书，图书ID:{}",ids);
        Integer result = bookService.batchDelete(ids);
        if(result <= 0){
            log.error("批量删除失败,ids:{}",ids);
            return "批量删除失败，请联系管理员";
        }
        return "";
    }


}
