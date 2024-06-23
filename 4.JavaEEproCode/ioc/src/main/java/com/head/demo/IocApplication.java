package com.head.demo;

import com.head.demo.component.UserComponent;
import com.head.demo.config.UserConfig;
import com.head.demo.controller.UserController;
import com.head.demo.repo.UserRepository;
import com.head.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);
//        // Spring 上下文->返回的就是Spring的运行环境
//        ApplicationContext context = SpringApplication.run(IocApplication.class, args);
//        UserController bean = context.getBean(UserController.class);
//        bean.doController();
//
//        // 从 context 中获取 bean
//        UserService userService = context.getBean(UserService.class);
//        userService.doService();
//
//        // 根据名称来获取 bean
//        UserService userService2 = (UserService) context.getBean("userService");
//        userService2.doService();
//
//        // 根据名称和类型获取 bean
//        UserService userService3 = context.getBean("userService",UserService.class);
//        userService3.doService();
//
//        // 特殊情况: 如果类名的前两位都为大写, bean 的前两位也为大写
//
//        UserRepository userRepository = context.getBean(UserRepository.class);
//        userRepository.doRepository();
//
//        UserComponent userComponent = context.getBean(UserComponent.class);
//        userComponent.doComponent();
//
//        UserConfig userConfig = context.getBean(UserConfig.class);
//        userConfig.doConfig();

    }

}
