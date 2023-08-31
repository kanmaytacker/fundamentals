package com.scaler.lld.bird.simple;

public class Runner {
    public static void main(String[] args) {
        Bird parrot = new Parrot(10.0, "Green", "Small", "Sharp", BirdType.Parrot);
        parrot.fly();

        Bird eagle = new Eagle(20.0, "Brown", "Medium", "Sharp", BirdType.Eagle);
        eagle.fly();
    }
}
