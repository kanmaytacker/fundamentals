package com.scaler.lld.bird;

import com.scaler.lld.bird.interfaces.FlyingBehaviour;

public class FlappingBehaviour implements FlyingBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flapping");
    }
}
