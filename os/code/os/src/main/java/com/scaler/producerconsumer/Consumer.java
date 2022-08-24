package com.scaler.producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Consumer implements Runnable {

    private Queue<UnitOfWork> store;
    private String name;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    @Override
    public void run() {
        while (true) {
            try {
                forConsumer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException("Error acquiring semaphore " + e);
            }

            store.remove();
            System.out.println("Consumed: " + name + " Left units :" + store.size());

            forProducer.release();

        }

    }

}
