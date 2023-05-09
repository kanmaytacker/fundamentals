package com.scaler.lld.vehicles.v1;

import com.scaler.lld.vehicles.enums.BikeType;

public class Bike extends Vehicle {
    
    BikeType bikeType;

    public Bike(String model, int mileage, BikeType bikeType) {
        super(model, mileage);
        this.bikeType = bikeType;
    }
}
