package com.head.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspectDemo {
    @Before("@annotation(com.head.aop.aspect.MyAspect)")
    public void doBefore(){
        log.info("执行MyAspectDemo before");
    }
    @After("@annotation(com.head.aop.aspect.MyAspect)")
    public void doAfter(){
        log.info("执行MyAspectDemo after");
    }
}
