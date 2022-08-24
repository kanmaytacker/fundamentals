package com.scaler.producerconsumer;

import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Producer implements Runnable {

    private Queue<UnitOfWork> store;
    private int maxSize;
    private String name;

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.size() < maxSize) {
                    store.add(new UnitOfWork());
                    System.out.println("Produced: " + name + " Left units :" + store.size());
                }
            }
        }

    }

}
