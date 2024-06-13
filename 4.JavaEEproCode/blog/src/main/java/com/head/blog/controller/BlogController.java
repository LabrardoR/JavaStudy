package com.head.blog.controller;


import com.head.blog.model.BlogInfo;
import com.head.blog.model.Result;
import com.head.blog.service.BlogService;
import com.head.blog.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    // 获取博客列表
    @RequestMapping("/getlist")
    public List<BlogInfo> getBookList(){
        return blogService.getBlogList();
    }

    // 获取博客详情
    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer blogId, HttpServletRequest request){
        BlogInfo blogInfo = blogService.getBlogDetail(blogId);
        // 判断作者是否为登录用户
        // 从token中获取userId
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        if(userId != null && userId.equals(blogInfo.getUserId())){
            blogInfo.setLoginUser(true);
        }
        return blogInfo;
    }

    // 添加博客
    @RequestMapping("/add")
    public Result publishBlog(String title, String content, HttpServletRequest request){
        // 从token中获取userId
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        if(userId == null && userId < 0){
            return Result.fail("用户未登录");
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle(title);
        blogInfo.setContent(content);
        blogInfo.setUserId(userId);
        blogService.insertBlog(blogInfo);
        return Result.success("success");
    }

    // 编辑博客
    @RequestMapping("/update")
    public boolean updateBlog(Integer id, String title, String content){
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle(title);
        blogInfo.setContent(content);
        // 根据博客ID去更新数据

        // 判断是否为作者本人
        blogInfo.setId(id);
        blogService.updateBlog(blogInfo);
        return true;
    }
    // 删除博客
    @RequestMapping("/delete")
    public boolean deleteBlog(Integer blogId){
        // 判断是否为作者本人
        // 需要获取登录用户和当前作者信息
        // 登录用户从token中获取
        //
        blogService.delete(blogId);
        return true;
    }
}
