package com.head.demo.ioc.v1;

public class Tire {
    private final int size;
    public Tire(int size){
        this.size = size;
        System.out.println("tire init...");
    }
}
