package com.scaler.lld.vehicles.v4;

public interface Vehicle {
    
    void start();

    void stop();

    void accelerate();

    void brake();

    default void go() {
        start();
        accelerate();
        brake();
        stop();
    }

}
