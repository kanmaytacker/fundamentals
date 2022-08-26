package com.scaler.addersubtractor;

import java.util.concurrent.locks.Lock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            count.getValue().getAndAdd(-i);
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