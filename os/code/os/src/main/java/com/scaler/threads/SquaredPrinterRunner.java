package com.scaler.threads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SquaredPrinterRunner {
    
 public static void main(String[] args) {
    List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Executor executor = Executors.newCachedThreadPool();
    for (Integer value : values) {
        executor.execute(new SquaredPrinter(value));
    }
 }
}
