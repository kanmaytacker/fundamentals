package com.scaler;

/**
 * Hello world!
 *
 */
public class App {

    public static void print() {
        System.out.println("Hello World! printed by: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        print();

        for (int i = 0; i < 10; i++) {
            TextPrinter textPrinter = new TextPrinter(String.valueOf(i));
            Thread thread = new Thread(textPrinter);
            thread.start();
        }
    }
}
