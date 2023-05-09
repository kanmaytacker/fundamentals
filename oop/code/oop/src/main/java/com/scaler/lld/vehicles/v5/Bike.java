package com.scaler.lld.vehicles.v5;

import com.scaler.lld.vehicles.enums.BikeType;

public class Bike extends Vehicle {

    BikeType bikeType;
    
    public Bike(String model, int mileage, BikeType bikeType) {
        super(model, mileage);
        this.bikeType = bikeType;
    }

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
