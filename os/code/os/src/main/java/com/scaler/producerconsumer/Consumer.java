package com.scaler.producerconsumer;

import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Consumer implements Runnable {

    private Queue<UnitOfWork> store;
    private String name;


    @Override
    public void run() {
       while (true) {
        if (store.size() > 0) {
            store.remove();
            System.out.println("Consumed: " + name + " Left units :" + store.size());
        }
       }
        
    }
    
}
