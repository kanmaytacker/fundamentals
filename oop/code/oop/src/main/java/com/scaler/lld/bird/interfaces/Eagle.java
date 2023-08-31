package com.scaler.lld.bird.interfaces;


public class Eagle extends Bird implements Flyable {

    public Eagle(Double weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    @Override
    public void fly() {
        System.out.println("\nEagle is flying");
    }
    
}
