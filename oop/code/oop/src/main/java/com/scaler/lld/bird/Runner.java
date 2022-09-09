package com.scaler.lld.bird;

public class Runner {
    public static void main(String[] args) {
        FlyingBird parrot = new Parrot(10, "Green", "Small", "Sharp", BirdType.Parrot);
        parrot.fly();

        FlyingBird eagle = new Eagle(20, "Brown", "Medium", "Sharp", BirdType.Eagle);
        eagle.fly();

        NonFlyingBird penguin = new Penguin(30, "Black", "Large", "Sharp", BirdType.Penguin);
        penguin.makeSound();
    }
}
