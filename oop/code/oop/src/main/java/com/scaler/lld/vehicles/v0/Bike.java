package com.scaler.lld.vehicles.v0;

import com.scaler.lld.vehicles.enums.BikeType;

public class Bike {
    
    String model;
    int mileage;

    BikeType bikeType;

    public Bike(String model, int mileage, BikeType bikeType) {
        this.model = model;
        this.mileage = mileage;
        this.bikeType = bikeType;
    }
}
