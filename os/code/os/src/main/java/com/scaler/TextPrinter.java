package com.scaler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextPrinter implements Runnable {

    private String text;

    @Override
    public void run() {
        System.out.println(text + " printed by: " + Thread.currentThread().getName());
    }
}
