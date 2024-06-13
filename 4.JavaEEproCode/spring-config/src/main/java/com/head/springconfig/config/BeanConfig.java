package com.head.springconfig.config;

import com.head.springconfig.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public User user1(){
        return new User();
    }
}
