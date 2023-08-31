package com.scaler.lld.bird.abstractclasses;

public abstract class FlyableBird extends Bird {
    public FlyableBird(Double weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    public abstract void fly();
}
