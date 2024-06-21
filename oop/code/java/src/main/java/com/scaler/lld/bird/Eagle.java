package com.scaler.lld.bird;

public class Eagle extends Bird {

    public Eagle(Integer weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    @Override
    public void fly() {
        System.out.println("\nEagle is flying");
    }
    
}
