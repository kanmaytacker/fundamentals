package com.scaler.lld.bird.abstractclasses;

public class Parrot extends FlyableBird {

    public Parrot(Double weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    @Override
    public void fly() {
        System.out.println("\nParrot is flying");
    }
    
}
