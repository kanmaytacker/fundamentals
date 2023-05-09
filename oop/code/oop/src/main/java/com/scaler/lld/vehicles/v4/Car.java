package com.scaler.lld.vehicles.v4;

public class Car implements Vehicle {

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
