package com.scaler.synckeyword.method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {

            // Acquire lock
            count.incrementCount(i);
            // Release the lock

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
