package com.scaler.lld.bird;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Bird {
    private Integer weight;
    private String colour;
    private String size;
    private String beakType;
    private BirdType type;

    public void fly() {
        if (type == BirdType.Eagle) {
            System.out.println("Eagle is flying");
        } else if (type == BirdType.Penguin) {
            System.out.println("Penguin is swimming");
        } else if (type == BirdType.Parrot) {
            System.out.println("Parrot is flying");
        }
    }
}
