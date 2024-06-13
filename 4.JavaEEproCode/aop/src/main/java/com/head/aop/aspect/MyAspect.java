package com.head.aop.aspect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//修饰范围
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface MyAspect {

}
