package com.head.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectDemo {
    @Pointcut("execution(* com.head.aop.controller.*.*(..))")
    private void pt(){}
    @Before("pt()")
    public void doBefore(){
        log.info("执行AspectDemo Before");
    }

    @After("pt()")
    public void doAfter(){
        log.info("执行AspectDemo After");
    }
    @AfterReturning("pt()")
    public void doAfterReturning(){
        log.info("执行AspectDemo AfterReturning");
    }
    @AfterThrowing("pt()")
    public void doAfterThrowing(){
        log.info("执行AspectDemo AfterThrowing");
    }
    @Around("pt()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("执行AspectDemo Around 前");
        Object result = joinPoint.proceed();
        log.info("执行AspectDemo Around 后");
        return result;
    }
}
