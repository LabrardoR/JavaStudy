package com.head.demo.ioc.v1;

import com.head.demo.ioc.v1.Bottom;

public class Framework {
    private Bottom bottom;
    Framework(int size){
        bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
