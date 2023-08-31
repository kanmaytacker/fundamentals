package com.scaler.lld.bird.dependency.beak;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Beak {
    private Double strength;
    private String material;
}
