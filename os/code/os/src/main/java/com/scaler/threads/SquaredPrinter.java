package com.scaler.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SquaredPrinter implements Runnable {

    private int number;

    @Override
    public void run() {
        System.out.println(number * number + " Printed by " + Thread.currentThread().getName());
    }

}

