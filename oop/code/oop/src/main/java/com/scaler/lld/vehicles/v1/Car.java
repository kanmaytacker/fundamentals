package com.scaler.lld.vehicles.v1;

import com.scaler.lld.vehicles.enums.CarType;

public class Car extends Vehicle {
    
    CarType carType;

    public Car(String model, int mileage, CarType carType) {
        super(model, mileage);
        this.carType = carType;
    }
}
