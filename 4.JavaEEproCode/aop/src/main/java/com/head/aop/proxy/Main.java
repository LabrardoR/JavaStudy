package com.head.aop.proxy;

public class Main {
    public static void main(String[] args) {
        // 目标对象
        HouseSubject subject = new RealHouseSubject();
        HouseProxy proxy = new HouseProxy(subject);
        proxy.rentHouse();
    }
}
