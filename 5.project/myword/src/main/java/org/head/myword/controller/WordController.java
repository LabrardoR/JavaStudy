package org.head.myword.controller;


import org.head.myword.model.domain.Word;
import org.head.myword.service.WordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/word")
@RestController
public class WordController {
    @Resource
    private WordService wordService;


    // 查询所有单词
    @RequestMapping("/select")
    public List<Word> selectAllWords(){
        List<Word> ret = new ArrayList<>();
        ret = wordService.list();
        return ret;
    }



}
