package org.head.myword.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.head.myword.model.domain.User;

/**
* @author headhead
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-07-07 17:10:36
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select count(distinct w.word_id) from user u, user_relate_word r, word w where u.user_id = #{userId} and r.user_id = u.user_id and r.word_id = w.word_id")
    int selectWordCountByUserId(Long userId);
}




