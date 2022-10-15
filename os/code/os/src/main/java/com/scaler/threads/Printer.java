package com.scaler.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Printer implements Runnable {

    private String text;

    @Override
    public void run() {
        System.out.println(text + " Printed by " + Thread.currentThread().getName());
    }
}
