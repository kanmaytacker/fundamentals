package com.scaler.atomicintegers;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    private AtomicInteger value = new AtomicInteger(0);

    public AtomicInteger getValue() {
        return value;
    }

}
