package com.scaler.lld.vehicles.v5;

import com.scaler.lld.vehicles.enums.CarType;

public class Car extends Vehicle {

    CarType carType;

    public Car(String model, int mileage, CarType carType) {
        super(model, mileage);
        this.carType = carType;
    }

    // Some common behaviour
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerated");
    }

    @Override
    public void brake() {
        System.out.println("Car braked");
    }

    // Some specific behaviour
    void openBoot() {
        // ...
    }

    void closeBoot() {
        // ...
    }
    
}
