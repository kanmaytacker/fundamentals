package com.scaler.lld.bird.interfaces;

public class Penguin extends Bird implements Swimmable {
    public Penguin(Double weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming.");
    }
}
