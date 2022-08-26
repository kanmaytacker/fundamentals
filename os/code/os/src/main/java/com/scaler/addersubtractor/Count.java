package com.scaler.addersubtractor;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    private AtomicInteger value = new AtomicInteger(0);

    public AtomicInteger getValue() {
        return value;
    }

    public void setValue(AtomicInteger value) {
        this.value = value;
    }
}
