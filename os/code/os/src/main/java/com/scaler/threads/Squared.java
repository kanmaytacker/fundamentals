package com.scaler.threads;

import java.util.concurrent.Callable;

public class Squared implements Callable<Integer> {
    private Integer number;

    public Squared(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        return number * number;
    }
}
