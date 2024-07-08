package org.head.myword.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.head.myword.model.domain.UserRelateWord;

/**
* @author headhead
* @description 针对表【user_relate_word(关联表,将用户和词库建立联系)】的数据库操作Mapper
* @createDate 2024-07-07 17:10:36
* @Entity generator.domain.UserRelateWord
*/
@Mapper
public interface UserRelateWordMapper extends BaseMapper<UserRelateWord> {

}




