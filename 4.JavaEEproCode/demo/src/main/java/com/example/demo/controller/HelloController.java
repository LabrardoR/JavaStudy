package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/hello")
//@RestController
//public class HelloController {
//    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
//    public String sayHi(){
//        return "hi,SpringBoot";
//    }
//
//    @RequestMapping("/sayHello")
//    public String sayHello(){
//        return "hello,SpringBoot";
//    }
//}


@RestController
//@RequestMapping
public class HelloController {
    @RequestMapping("/sayHi")
    public String sayHi(){
        return "hello, SpringBoot!";
    }
}
