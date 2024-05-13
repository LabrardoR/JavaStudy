package com.head.demo.ioc.v1;

import com.head.demo.ioc.v1.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(15);
        car.run();
    }
}
