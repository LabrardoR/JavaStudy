package com.head.demo.controller;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggerController {
   // private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);


    // 初始化注解
    @PostConstruct
    public void print(){
        System.out.println("打印日志");
        log.info("=====我是日志框架你马了个臭批====");
        log.error("我是error日志");
        log.warn("我是warn日志");
        log.info("我是info日志");
        log.debug("我是debug日志");
        log.trace("我是trace日志");
    }
}
