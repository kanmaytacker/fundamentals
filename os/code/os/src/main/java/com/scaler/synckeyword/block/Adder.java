package com.scaler.synckeyword.block;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {


            synchronized (count) {
                // Acquire lock
                int value = count.getValue();
                int nextValue = value + i;
                count.setValue(nextValue);
                // Release the lock
            }
        }

    }
}
// A a = new A()
// new B(a)
// b.setA(a2)
// new B(a)

// A a1 = new A()
// A a2 = new A()

// A a = new A()
// a.run()

// A a1 = new A()
// A a2 = new A()
// a1.run() a2.run()
// sync(A.class)
