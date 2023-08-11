package com.scaler.synckeyword.method;

public class Count {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementCount(int offset) {
        this.value += offset; // Reading and updating the common value
    }

    public synchronized void decrementCount(int offset) {
        this.value -= offset;
    }


}
