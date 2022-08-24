package com.scaler.producerconsumer;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Runner {

    private static final Set<String> producerNames = Set.of("p1", "p2", "p3");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {
        Queue<UnitOfWork> store = new ConcurrentLinkedDeque<>();
        int maxSize = 20;

        Semaphore forProducer = new Semaphore(maxSize);
        Semaphore forConsumer = new Semaphore(0);

        Set<Producer> producers = producerNames
                .stream()
                .map(name -> new Producer(store, maxSize, name, forProducer, forConsumer))
                .collect(Collectors.toSet());

        Set<Consumer> consumers = consumerNames
                .stream()
                .map(name -> new Consumer(store, name, forProducer, forConsumer))
                .collect(Collectors.toSet());

        producers.forEach(producer -> new Thread(producer).start());
        consumers.forEach(consumer -> new Thread(consumer).start());

    }
}
