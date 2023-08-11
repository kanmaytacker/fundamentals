package com.scaler.synckeyword.block;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Something wrong happened");
        }

        System.out.println(count.getValue());
    }
}
