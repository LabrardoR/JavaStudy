package com.example.demo.controller;

import com.example.demo.model.MessageInfo;
import com.example.demo.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo){
        log.info("发表留言");
        if(!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage()))
            return false;
        // 添加留言
        messageService.addMessage(messageInfo);
        return true;
    }
    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo(){
        return messageService.getMessageInfo();
    }

}
