package org.head.myword.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.head.myword.mapper.UserRelateWordMapper;
import org.head.myword.model.domain.UserRelateWord;
import org.head.myword.service.UserRelateWordService;

import org.springframework.stereotype.Service;

/**
* @author headhead
* @description 针对表【user_relate_word(关联表,将用户和词库建立联系)】的数据库操作Service实现
* @createDate 2024-07-07 17:10:36
*/
@Service
public class UserRelateWordServiceImpl extends ServiceImpl<UserRelateWordMapper, UserRelateWord>
    implements UserRelateWordService{

}




