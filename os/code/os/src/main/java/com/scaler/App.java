package com.scaler;

import com.scaler.threads.Printer;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello world. Printed by :" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            Printer printer = new Printer(String.valueOf(i));
            Thread thread = new Thread(printer);
            thread.start();
        }
    }
}

// Print number 1 to 10 on a single thread
// Print number 1 to 10 each on different threads
// 1 - Thread 1
// 2 - Thread 2
// ...
// 10 Thread 10

//