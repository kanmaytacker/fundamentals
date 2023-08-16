package com.scaler.atomicintegers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            count.getValue().getAndAdd(-i);
        }

    }
}

// x+= i - syntactic sugar
//