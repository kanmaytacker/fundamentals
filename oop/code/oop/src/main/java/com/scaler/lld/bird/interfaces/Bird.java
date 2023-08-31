package com.scaler.lld.bird.interfaces;

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

    public void eat() {
        System.out.println(type + " is eating!");
    }

    public void sleep() {
        System.out.println(type + " is sleeping!");
    }
}
