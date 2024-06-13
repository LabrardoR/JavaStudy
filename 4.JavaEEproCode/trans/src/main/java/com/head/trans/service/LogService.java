package com.head.trans.service;

import com.head.trans.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;
    public Integer insertLog(String userName, String op){
        return logInfoMapper.insert(userName, op);
    }
}
