package com.scaler.lld.bird.dependency;

import com.scaler.lld.bird.dependency.beak.Beak;
import com.scaler.lld.bird.dependency.beak.StrongBeak;
import com.scaler.lld.bird.dependency.beak.WeakBeak;
import com.scaler.lld.bird.dependency.birds.Bird;
import com.scaler.lld.bird.dependency.birds.Parrot;
import com.scaler.lld.bird.dependency.birds.Penguin;
import com.scaler.lld.bird.dependency.enums.BirdType;
import com.scaler.lld.bird.dependency.interfaces.Flyable;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Beak strongBeak = new StrongBeak(10.0, "calcium");
        Parrot parrot = new Parrot(10.0, "Green", "Small", "Sharp", BirdType.Parrot, strongBeak);
        printBeak(parrot);

        Beak weakBeak = new WeakBeak(1.0, "rubber");
        Penguin penguin = new Penguin(20.0, "White", "Small", "Sharp", BirdType.Penguin, weakBeak);
        printBeak(penguin);
    }

    private static void printBeak(Bird bird) {
        String message = String.format("%s has a beak made of %s and strength: %.1f", bird.getType(), bird.getBeak().getMaterial(), bird.getBeak().getStrength());
        System.out.println(message);
    }

}
