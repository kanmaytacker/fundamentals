package com.scaler.lld.vehicles.v5;

import com.scaler.lld.vehicles.enums.BikeType;
import com.scaler.lld.vehicles.enums.CarType;

public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car("Honda City", 20, CarType.SEDAN);
        System.out.println(car.model);
        car.go();

        Bike bike = new Bike("Ducati Monster", 15, BikeType.SPORTS);
        System.out.println(bike.model);
        bike.go();
        
    }
}
