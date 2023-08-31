package com.scaler.lld.bird.abstractclasses;

public abstract class NonFlyableBird extends Bird {
    public NonFlyableBird(Double weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }
}
