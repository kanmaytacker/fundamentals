package com.scaler.lld.bird.interfaces;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Parrot parrot = new Parrot(10.0, "Green", "Small", "Sharp", BirdType.Parrot);
        parrot.eat();

        Penguin penguin = new Penguin(20.0, "White", "Small", "Sharp", BirdType.Penguin);
        penguin.eat();

        fly(List.of(parrot));
    }

    private static void fly(List<Flyable> birds) {
        birds.forEach(Flyable::fly);
    }
}
