package com.example.demo.controller;


import com.example.demo.Person;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/return")
@Controller
public class ReturnController {

    @RequestMapping("/index")
    public String returnIndex(){
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData(){
        return "返回视图需要的数据";
    }

    // 3. 返回 html 代码片段
    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml(){
        return "<h1>返回HTML代码片段</h1>";
    }

    // 返回 JSON
    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson(){
        Person person = new Person();
        person.setId(1);
        person.setAge(20);
        person.setName("head");
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMap")
    public Map<String,String> returnMap(){
        Map<String,String> kv = new HashMap<>();
        kv.put("k1","v1");
        kv.put("k2","v2");
        kv.put("k3","v3");
        return kv;
    }

    // 5. 设置 http 状态码 ->而非业务状态码
    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response){
        response.setStatus(401);// 通常表示没有登录
        return "设置状态码";
    }

    // 设置 Header (了解)
    @ResponseBody
    @RequestMapping(value = "/r1",produces = "application/json;charset=utf8")
    public String r1(HttpServletResponse response){
        response.setHeader("myhead","myhead");
        return "{'OK',1}";
    }
}
