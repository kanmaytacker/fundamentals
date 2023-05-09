package com.scaler.lld.vehicles.v3;

public class Car implements Vehicle {

    // Some common behaviour
    @Override
    public void start() {
        // ...
    }

    @Override
    public void stop() {
        // ...
    }

    @Override
    public void accelerate() {
        // ...
    }

    @Override
    public void brake() {
        // ...
    }

    // Some specific behaviour
    void openBoot() {
        // ...
    }

    void closeBoot() {
        // ...
    }
    
}
