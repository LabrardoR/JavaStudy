package com.head.aop.proxy;

public class HouseProxy implements HouseSubject{
    // 目标对象,被代理对象
    private HouseSubject houseSubject;

    public HouseProxy(HouseSubject houseSubject) {
        this.houseSubject = houseSubject;
    }

    @Override
    public void rentHouse() {
        System.out.println("开始进行代理");
        houseSubject.rentHouse();
        System.out.println("结束代理");
    }

    @Override
    public void saleHouse() {
        System.out.println("开始进行代理");
        houseSubject.saleHouse();
        System.out.println("结束代理");
    }
}
