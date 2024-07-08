package org.head.myword.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.head.myword.mapper.WordMapper;
import org.head.myword.model.domain.Word;
import org.head.myword.service.WordService;

import org.springframework.stereotype.Service;

/**
* @author headhead
* @description 针对表【word】的数据库操作Service实现
* @createDate 2024-07-07 17:10:36
*/
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word>
    implements WordService{

}




