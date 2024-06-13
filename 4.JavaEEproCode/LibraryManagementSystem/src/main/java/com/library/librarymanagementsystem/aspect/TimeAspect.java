package com.library.librarymanagementsystem.aspect;

// 第三方的注解
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {
                            // 作用的目标方法
    @Around("execution(* com.library.librarymanagementsystem.controller.*.*(..))")
    public Object timeConst(ProceedingJoinPoint joinPoint) throws Throwable {
        // 方法执行前的逻辑
        long start = System.currentTimeMillis();
        // 执行目标方法
        Object result = joinPoint.proceed();
        // 方法执行后的逻辑
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "消耗时间：" + (end - start) + "ms");
        return result;
    }
}
