package com.scaler.lld.vehicles.v5;

public abstract class Vehicle {

    String model;
    int mileage;

    public Vehicle(String model, int mileage) {
        this.model = model;
        this.mileage = mileage;
    }

    abstract void start();

    abstract void stop();

    abstract void accelerate();

    abstract void brake();

    void go() {
        start();
        accelerate();
        brake();
        stop();
    }

}
