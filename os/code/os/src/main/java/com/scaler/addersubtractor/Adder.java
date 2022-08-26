package com.scaler.addersubtractor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            count.getValue().getAndAdd(i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }
        }

    }
}
