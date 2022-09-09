package com.scaler.lld.bird;

import com.scaler.lld.bird.interfaces.Flyable;
import com.scaler.lld.bird.interfaces.Swimmable;

public class Runner {
    public static void main(String[] args) {
        Flyable parrot = new Parrot(10, "Green", "Small", "Sharp", BirdType.Parrot);
        parrot.fly();

        Flyable eagle = new Eagle(20, "Brown", "Medium", "Sharp", BirdType.Eagle);
        eagle.fly();

        Bird penguin = new Penguin(30, "Black", "Large", "Sharp", BirdType.Penguin);
        penguin.makeSound();

        // Make a pengiun swim
        ((Swimmable) penguin).swim();
    }
}
