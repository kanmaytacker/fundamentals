package com.scaler.lld.bird.dependency.birds;

import com.scaler.lld.bird.dependency.beak.Beak;
import com.scaler.lld.bird.dependency.enums.BirdType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Bird {
    
    private Double weight;
    private String colour;
    private String size;
    private String beakType;
    private BirdType type;

    private Beak beak;

    public void eat() {
        System.out.println(type + " is eating!");
    }

    public void sleep() {
        System.out.println(type + " is sleeping!");
    }
}
