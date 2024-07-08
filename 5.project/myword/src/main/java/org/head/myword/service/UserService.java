package org.head.myword.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.head.myword.model.domain.User;

/**
* @author headhead
* @description 针对表【user】的数据库操作Service
* @createDate 2024-07-07 17:10:36
*/
public interface UserService extends IService<User> {

    int findWordCountByUserId(Long userId);
}
