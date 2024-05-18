package com.head.mybatisdemo.mapper;

import com.head.mybatisdemo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleInfoMapper {
    @Select("select * from articleinfo where id = #{articleId}")
    ArticleInfo selectById(Integer articleId);

    @Select(" select ta.* , tb.username, tb.age from articleinfo ta " +
            " LEFT JOIN userinfo tb on ta.uid = tb.id " +
            " where ta.id=1 ")
    ArticleInfo selectArticleAndUserById(Integer articleId);

}
