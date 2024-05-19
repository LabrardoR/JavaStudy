package com.example.demo.controller;


import com.example.demo.model.Person;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name){
        return "接收到参数name:" + name;
    }

    @RequestMapping("/m2")
    public String m2(String name, Integer age){
        return "接收到参数name:" + name + ",age:" + age;
    }
    @RequestMapping("/m3")
    public String m3(String name, int age){
        return "接收到参数name:" + name + ",age:" + age;
    }
    @RequestMapping("/m4")
    public String m4(Person person){

        return "接收到参数person:"+person;
    }

    @RequestMapping("/m5")
    public String m5(@RequestParam(value = "name",required = false) String userName){
        return "接收到参数name:" + userName;
    }

    @RequestMapping("/m6")
    public String m6(String[] arrayParam){
        return "接收到参数arrayParam:" + Arrays.toString(arrayParam);
    }

    @RequestMapping("/m7")
    public String m7(@RequestParam(required = false) List<String> listParam){
        return "接收到参数listParam:" + listParam + ",长度:" + listParam.size();
    }

    @RequestMapping("/m8")
    public String m8(@RequestBody Person person){
        return "接收到参数person:" + person.toString();
    }

    //可以获取一个,也可以获取多个,但要注意顺序,且必须全写
    @RequestMapping("/m9/{userId}/{name}")
    public String m9(@PathVariable Integer userId, @PathVariable("name") String userName){
        return "接收到参数userId = "+ userId + ", name = " + userName;
    }

    //接受文件
    @RequestMapping("/m10")
    public String m10(@RequestPart MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("C:/Users/headhead/Desktop/"+ file.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
//        }

        if (cookies != null){
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            });
        }
        return "获取cookie成功";
    }
    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue String head){

        return "cookie中head的值" + head;
    }

    @RequestMapping("/serSession")
    public String setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username","zhangsan");
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);//默认值为true->如果 session 不存在,就会自动创建一个
        if (session != null){
            String username = (String)session.getAttribute("username");
            return "登录用户:" + username;
        }
        return "session为空";
    }

    @RequestMapping("/getSession2")
    public String getSession2(@SessionAttribute(required = false) String username){
        return "username:" + username;
    }

    @RequestMapping("/getSession3")
    public String getSession3(HttpSession session){
        String username = (String)session.getAttribute("username");
        return "登录用户: " + username;
    }

    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "userAgent:" + userAgent;
    }
}
