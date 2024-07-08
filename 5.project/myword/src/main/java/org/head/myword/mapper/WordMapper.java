package org.head.myword.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.head.myword.model.domain.Word;

/**
* @author headhead
* @description 针对表【word】的数据库操作Mapper
* @createDate 2024-07-07 17:10:36
* @Entity generator.domain.Word
*/
@Mapper
public interface WordMapper extends BaseMapper<Word> {

}




