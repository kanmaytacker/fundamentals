package com.scaler.lld.bird.dependency.birds;

import com.scaler.lld.bird.dependency.beak.Beak;
import com.scaler.lld.bird.dependency.enums.BirdType;
import com.scaler.lld.bird.dependency.interfaces.Swimmable;

public class Penguin extends Bird implements Swimmable {
    public Penguin(Double weight, String colour, String size, String beakType, BirdType type, Beak beak) {
        super(weight, colour, size, beakType, type, beak);
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming.");
    }
}
