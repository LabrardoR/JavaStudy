package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    private final List<MessageInfo> messageInfos = new ArrayList<>();
    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo){
        String from = messageInfo.getFrom();
        String to = messageInfo.getTo();
        String message = messageInfo.getMessage();
        if(!StringUtils.hasLength(from) || !StringUtils.hasLength(to) || !StringUtils.hasLength(message))
            return false;

        // 添加留言
        messageInfos.add(messageInfo);
        return true;
    }
    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo(){
        return messageInfos;
    }

}
