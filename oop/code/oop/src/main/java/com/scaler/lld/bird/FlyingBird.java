package com.scaler.lld.bird;

public abstract class FlyingBird extends Bird {

    public FlyingBird(Integer weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }

    public abstract void fly();
    
}
