package com.scaler.lld.vehicles.v4;

public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike accelerated");
    }

    @Override
    public void brake() {
        System.out.println("Bike braked");
    }

    // Some specific behaviour
    void sideStandUp() {
        // ...
    }

    void sideStandDown() {
        // ...
    }
}
