package com.scaler.lld.bird;

import com.scaler.lld.bird.interfaces.Flyable;
import com.scaler.lld.bird.interfaces.FlyingBehaviour;

public class Eagle extends Bird implements Flyable {

    private FlyingBehaviour flyingBehaviour;
    public Eagle(Integer weight, String colour, String size, String beakType, BirdType type, FlyingBehaviour flyingBehaviour) {
        super(weight, colour, size, beakType, type);
        this.flyingBehaviour = flyingBehaviour;
    }   

    @Override
    public void fly() {
        flyingBehaviour.makeFly();
    }

    @Override
    public void makeSound() {
        // TODO Auto-generated method stub
    }
    
}
