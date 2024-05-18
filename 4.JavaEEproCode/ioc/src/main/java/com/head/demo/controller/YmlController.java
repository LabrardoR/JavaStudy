package com.head.demo.controller;

import com.head.demo.model.DBType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlController {
    @Value("${demo.key1}")
    private String key1;

    @Value("${demo.key2}")
    private String key2;

    @Value("${demo.key3}")
    private String key3;
    @RequestMapping("/readYml")
    public String readYml(){
        return key1;
    }

    @RequestMapping("/readKey2")
    public String readKey2(){
        return key2;
    }

    @PostConstruct
    public void init(){
//        System.out.println("key1: "+key1);
//        System.out.println("key2: "+key2);
//        System.out.println("key3: "+key3);
        //System.out.println("dbtype:"+ dbType + dbType.getName().size());
    }

    @Autowired
    public DBType dbType;

}
