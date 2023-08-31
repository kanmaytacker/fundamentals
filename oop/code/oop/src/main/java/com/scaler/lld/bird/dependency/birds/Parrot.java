package com.scaler.lld.bird.dependency.birds;

import com.scaler.lld.bird.dependency.beak.Beak;
import com.scaler.lld.bird.dependency.enums.BirdType;
import com.scaler.lld.bird.dependency.interfaces.Flyable;

public class Parrot extends Bird implements Flyable {

    public Parrot(Double weight, String colour, String size, String beakType, BirdType type, Beak beak) {
        super(weight, colour, size, beakType, type, beak);
    }

    @Override
    public void fly() {
        System.out.println("\nParrot is flying");
    }
    
}
