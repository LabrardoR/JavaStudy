package com.example.demo.mapper;

import com.example.demo.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;
    @Test
    void insertMessage() {
        MessageInfo messageInfo = new MessageInfo();

        messageMapper.insertMessage();
    }
}