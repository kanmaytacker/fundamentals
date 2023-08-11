package com.scaler.synckeyword.block;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {

            synchronized (count) {

                int value = count.getValue();
                int nextValue = value - i;
                count.setValue(nextValue);

            }
        }

    }
}