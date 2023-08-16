# Atomic integers
- [Atomic integers](#atomic-integers)
  - [Motivation](#motivation)
    - [Contention](#contention)
  - [Atomic integers](#atomic-integers-1)
  - [Advantages of atomic integers](#advantages-of-atomic-integers)
  - [Additional reading](#additional-reading)

## Motivation

In concurrent programming, it is often necessary to update a shared variable. For example, a counter that is incremented by multiple threads. Remember the `Count` variable in the adder and subtractor problem.

```java
class Adder extends Runnable {

    private Count count;

    public void run() {
        int currentValue = count.getValue();
        int nextValue = currentValue + index;
        count.setValue(nextValue);
    }
}
```

The major source of the data inconsistency is our approach to update the shared variable. There are multiple steps involved in updating the shared variable. Each step is not atomic. That is, each step can be interrupted by other threads. For example, you read the current value of the counter, and before you update the counter, another thread updates the counter. Then, when you update the counter, you are using the old value of the counter. This is a data inconsistency.

A solution to this problem is to make the update of the shared variable atomic. That is, the update of the shared variable is not interrupted by other threads. The synchronized keyword or the lock mechanism can be used to make the update of the shared variable atomic. However, the synchronized keyword and the lock mechanism increase the contention of the shared variable.

### Contention
Contention refers to a situation in concurrent programming where multiple threads compete for the same shared resource, such as a variable or a section of memory, that can only be accessed by one thread at a time. When threads contend for a resource, they may need to wait or be delayed, which can lead to performance degradation, increased latency, and reduced scalability.

In the context of synchronization mechanisms like locks, high contention can occur when many threads attempt to acquire the same lock simultaneously. This can result in contention overhead, where threads spend significant time waiting for the lock to be released by other threads. Contention can be a major source of performance degradation in concurrent programs.

## Atomic integers

Java provides a class called `AtomicInteger` to make the update of the shared variable atomic through different methods such as `getAndIncrement()`, `getAndDecrement()`, `getAndAdd()`, and `compareAndSet()`. The `AtomicInteger` class is located in the `java.util.concurrent.atomic` package.

Let us rewrite the adder and subtractor problem using the `AtomicInteger` class.
First update the `Count` class.

```java
class Count {

    private AtomicInteger value;

    public AtomicInteger getValue() {
        return value;
    }
}
```

Then update the `Adder` class.

```java
class Adder extends Runnable {

    private Count count;

    public void run() {
        count.getValue().getAndAdd(index);
    }
}
```

Here the `getAndAdd()` method is used to increment the counter by the value of `index`. The `getAndAdd()` method returns the old value of the counter.

The `getAndAdd()` method is atomic. That is, the update of the counter is not interrupted by other threads. The `getAndAdd()` method is more efficient than the `synchronized` keyword and the lock mechanism. That is, the `getAndAdd()` method has less contention than the `synchronized` keyword and the lock mechanism.

## Advantages of atomic integers

Atomic integers are often considered better than using the `synchronized` keyword or locks in certain scenarios due to their performance, simplicity, and reduced contention. Here are some reasons why atomic integers can be preferred:

1. **Reduced Contention:** Atomic integers provide a fine-grained approach to synchronization, which reduces contention compared to using locks. Contention occurs when multiple threads compete for access to a shared resource. With atomic operations, the contention is minimized because threads can update the value without blocking each other.

2. **Performance:** Atomic operations are implemented using low-level hardware instructions or native methods, making them more efficient than using locks, which involve context switching and potentially higher overhead.

3. **Non-Blocking:** Atomic operations are typically implemented using non-blocking algorithms, which means that threads do not block or wait for locks. Instead, they keep trying to perform the operation until successful, minimizing thread idling and resource waste.

4. **Simplicity:** Using atomic integers is often simpler and less error-prone than managing locks manually. It reduces the risk of deadlocks, race conditions, and other synchronization-related issues.

5. **Scalability:** Atomic operations can often lead to better scalability, especially in highly concurrent systems, because they reduce contention and allow more parallelism among threads.

6. **Read-Modify-Write Operations:** Atomic integers are particularly useful for scenarios involving read-modify-write operations (e.g., incrementing a counter), where maintaining consistency is important without the need for a full lock.

However, it's important to note that atomic operations have their limitations:

- Atomic integers are suitable for simple operations like incrementing and comparing. For more complex scenarios, locks or other synchronization mechanisms might be more appropriate.
- Atomic operations work well for a single variable, but they don't provide the same level of control over multiple variables and complex interactions that locks can offer.
- Using atomic operations doesn't replace the need for synchronization entirely. They are a tool to be used in specific situations where they provide clear benefits.

Ultimately, the choice between using atomic integers, locks, or other synchronization mechanisms depends on the specific requirements and characteristics of the concurrent problem you are trying to solve. It's important to carefully consider the trade-offs and performance characteristics of each approach in your particular context.

## Additional reading

Atomic data structures use a lock-free approach to provide synchronization in concurrent programming without relying on traditional locks. Instead of using locks to protect shared resources, atomic data structures employ atomic operations, such as Compare-And-Swap (CAS), to ensure safe and concurrent access.

Lock-free programming and CAS (Compare-And-Swap) are advanced concepts in concurrent programming that aim to provide efficient synchronization mechanisms without the need for traditional locks or explicit synchronization. These concepts are crucial for building highly performant and scalable multi-threaded applications.

**Lock-Free Programming:**
Lock-free programming is an approach in concurrent programming where threads work independently and make progress without waiting for other threads to release locks. In a lock-free scenario, at least one thread is guaranteed to make progress within a finite number of steps, even in the presence of contention.

Key characteristics of lock-free programming:

1. **Progress Guarantee:** In a lock-free algorithm, at least one thread will eventually complete its operation without being blocked by others. This ensures that the system as a whole continues to make progress.

2. **No Deadlocks:** Lock-free algorithms eliminate the risk of deadlocks, a common issue in traditional lock-based synchronization where threads can get stuck waiting for locks held by other threads.

3. **Reduced Contention:** Lock-free algorithms aim to minimize contention for shared resources by allowing threads to perform independent operations without blocking each other.

4. **Higher Scalability:** Lock-free programming can lead to better scalability in multi-core systems, as it enables more efficient utilization of available processing resources.

**Compare-And-Swap (CAS):**
CAS is a fundamental atomic operation used in lock-free programming. It is a hardware-supported mechanism that allows a thread to update a value in memory if it matches an expected value. CAS consists of three main steps: compare the current value with the expected value, swap the new value if the comparison succeeds, and return the outcome of the operation.

CAS operation:
```
CAS(address, expectedValue, newValue)
```

CAS ensures that the value is updated atomically only if the expected value matches the current value. If the values don't match, the operation fails, indicating that another thread has modified the value in the meantime. This allows for safe and lock-free updates of shared data.

CAS is a building block for many lock-free algorithms and data structures. It is used to implement atomic operations on variables, such as incrementing a counter, updating a reference, or performing other complex operations.

Benefits of CAS:

1. **Efficiency:** CAS is often more efficient than traditional locks, as it avoids the overhead of acquiring and releasing locks.

2. **Aiding Lock-Free Programming:** CAS enables the implementation of lock-free algorithms by allowing threads to compete for shared resources without causing conflicts or contention.

3. **Preventing Race Conditions:** CAS ensures that updates to shared data are performed atomically, preventing race conditions and maintaining data consistency.

Find below a pseudo-code for the `AtomicInteger` class.
```java
class AtomicInteger {
    private volatile int value;

    public AtomicInteger(int initialValue) {
        value = initialValue;
    }

    public int get() {
        return value;
    }

    public void set(int newValue) {
        value = newValue;
    }

    public int incrementAndGet() {
        // Pseudo-code for hardware-supported atomic increment
        atomically {
            value += 1;
            return value;
        }
    }

    public boolean compareAndSet(int expectedValue, int newValue) {
        // Pseudo-code for hardware-supported compare-and-swap
        atomically {
            if (value == expectedValue) {
                value = newValue;
                return true;
            }
            return false;
        }
    }
    
    // Other methods for atomic operations like addAndGet, getAndSet, etc.
}

```

In this pseudo-code example:

* The AtomicInteger class maintains a volatile value to store the integer value.
* The incrementAndGet method demonstrates how a hardware-supported atomic increment operation might work, ensuring that the value is incremented atomically without the need for explicit locking.
* The compareAndSet method illustrates how a hardware-supported compare-and-swap operation might be used to update the value atomically based on a condition.
* The methods get and set simply read and write the value, respectively.