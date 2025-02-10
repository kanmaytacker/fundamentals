package com.scaler.lld.bird;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Bird {
    private Integer weight;
    private String colour;
    private String size;
    private String beakType;
    private BirdType type;

    public abstract void fly();
}
