package com.scaler.producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Producer implements Runnable {

    private Queue<UnitOfWork> store;
    private int maxSize;
    private String name;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    @Override
    public void run() {
        while (true) {
            try {
                forProducer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException("Error acquiring semaphore " + e);
            }

            store.add(new UnitOfWork());
            System.out.println("Produced: " + name + " Left units :" + store.size());

            forConsumer.release();
        }

    }

}
