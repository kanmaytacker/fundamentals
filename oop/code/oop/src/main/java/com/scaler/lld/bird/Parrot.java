package com.scaler.lld.bird;

import com.scaler.lld.bird.interfaces.Flyable;

public class Parrot extends Bird implements Flyable {

    public Parrot(Integer weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    @Override
    public void fly() {
        System.out.println("\nParrot is flying");
    }

    @Override
    public void makeSound() {
        // TODO Auto-generated method stub
    }
    
}
