package com.scaler.addersubtractor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            
            int value = count.getValue();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            int nextValue = value - i;
            count.setValue(nextValue);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            for (int j = 0; j < 10000; ++j) {
                // do something
            }
        }

    }
}