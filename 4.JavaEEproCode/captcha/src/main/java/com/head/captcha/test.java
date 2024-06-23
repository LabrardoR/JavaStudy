package com.head.captcha;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")

public class test {
    @RequestMapping("/hi")
    public String hi(){
        return "hello";
    }
}
