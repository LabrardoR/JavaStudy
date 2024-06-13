package com.head.blog.service;

import com.head.blog.mapper.BlogInfoMapper;
import com.head.blog.model.BlogInfo;
import com.head.blog.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    public List<BlogInfo> getBlogList(){
        return blogInfoMapper.queryBlogList();
    }

    public BlogInfo getBlogDetail(Integer id){
        return blogInfoMapper.queryById(id);
    }


    public Integer insertBlog(BlogInfo blogInfo) {
        return blogInfoMapper.addBlog(blogInfo);
    }

    public Integer updateBlog(BlogInfo blogInfo) {
        return blogInfoMapper.updateBlog(blogInfo);
    }

    public void delete(Integer blogId) {
        blogInfoMapper.deleteBlog(blogId);
    }
}
