package com.scaler.lld.vehicles.v0;

import com.scaler.lld.vehicles.enums.CarType;

public class Car {

    // Some common state
    String model;
    int mileage;

    // Some specific state
    CarType carType;

    public Car(String model, int mileage, CarType carType) {
        this.model = model;
        this.mileage = mileage;
        this.carType = carType;
    }

}
