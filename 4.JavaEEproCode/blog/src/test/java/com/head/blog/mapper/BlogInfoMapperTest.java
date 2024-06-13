package com.head.blog.mapper;

import com.head.blog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogInfoMapperTest {
    @Autowired
    private BlogInfoMapper blogInfoMapper;
    @Test
    void queryBlogList() {
        blogInfoMapper.queryBlogList();
    }

    @Test
    void queryById() {
        blogInfoMapper.queryById(1);
    }

    @Test
    void updateBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setContent("这是一篇测试博客的内容");
        blogInfo.setTitle("测试博客的title");
        blogInfo.setId(2); // 此处是博客id
        blogInfoMapper.updateBlog(blogInfo);
    }

    @Test
    void deleteBlog() {
        blogInfoMapper.deleteBlog(1);
    }

    @Test
    void addBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setContent("这是一篇测试博客的内容");
        blogInfo.setTitle("测试博客的title");
        blogInfo.setUserId(1);  // 此处是用户id
        blogInfoMapper.addBlog(blogInfo);
    }
}