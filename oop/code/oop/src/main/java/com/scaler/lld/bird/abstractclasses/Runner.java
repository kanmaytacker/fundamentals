package com.scaler.lld.bird.abstractclasses;

public class Runner {
    public static void main(String[] args) {
        FlyableBird parrot = new Parrot(10.0, "Green", "Small", "Sharp", BirdType.Parrot);
        parrot.fly();

        NonFlyableBird penguin = new Penguin(20.0, "White", "Small", "Sharp", BirdType.Penguin);
        penguin.eat();
    }
}
