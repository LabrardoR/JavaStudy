package org.head.myword.controller;

import org.head.myword.model.domain.User;
import org.head.myword.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    // 查询所有用户
    @RequestMapping("/select")
    public List<User> selectAllUsers(){
        List<User> ret = new ArrayList<>();
        ret = userService.list();
        return ret;
    }
    @RequestMapping("/{userId}/wordCount")
    public Integer getWordCountByUserId(@PathVariable Long userId){
        if(userId == null){
            System.out.println("参数错误");
        }
        System.out.println(userId);
        Integer wordCount = userService.findWordCountByUserId(userId);
        System.out.println(wordCount);
        return wordCount;
    }


}
