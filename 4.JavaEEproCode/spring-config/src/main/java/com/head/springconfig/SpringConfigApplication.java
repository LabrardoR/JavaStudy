package com.head.springconfig;

import com.head.springconfig.model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringConfigApplication.class, args);
        User user = context.getBean(User.class);
        System.out.println("当前对象地址：" + System.identityHashCode(user));
    }

}
