# Concurrency and multithreading

**Concurrency-1: Introduction to Processes and Threads**

1. What is a process in the context of multithreading?
   - A. A single execution unit of a program
   - B. A single execution unit of an operating system
   - C. A single execution unit of a Java class
   - D. A single execution unit of a method

2. What is a thread in Java?
   - A. A lightweight process that shares memory space with other threads in the same process
   - B. An independent program that runs concurrently with other programs
   - C. A Java class that extends the `Thread` class
   - D. A Java interface for implementing multithreading.

3. How can you create a new thread in Java?
   - A. By extending the `Runnable` interface
   - B. By extending the `Thread` class
   - C. By implementing the `Executor` interface
   - D. By implementing the `Runnable` interface and passing it to a `Thread` constructor.

**Concurrency-2: Executors and Callables**

4. What is the purpose of the `Executor` framework in Java?
   - A. To create and manage threads manually
   - B. To provide a higher-level abstraction for executing tasks asynchronously
   - C. To synchronize access to shared resources
   - D. To define the `Executor` interface.

5. Which interface is used to represent a task that can return a result or throw an exception in a multithreaded environment?
   - A. `Runnable`
   - B. `Callable`
   - C. `Thread`
   - D. `Executor`.

6. How can you submit a `Callable` to an `ExecutorService` and retrieve its result?
   - A. Use the `submit` method, and then call `get()` on the returned `Future`.
   - B. Use the `execute` method and retrieve the result using a callback.
   - C. Use the `start` method of a `Thread` and then call `join` on the thread.
   - D. Use the `submit` method, and the result is automatically available in the `Callable` object.

**Concurrency-3: Introduction to Synchronization**

7. What is synchronization in Java multithreading?
   - A. The process of making a thread sleep for a specified duration
   - B. The process of controlling access to shared resources to prevent data corruption or race conditions
   - C. The process of terminating a thread's execution
   - D. The process of setting the thread's priority.

8. Which keyword is used to declare a synchronized method in Java?
   - A. `sync`
   - B. `synchronized`
   - C. `lock`
   - D. `threadsafe`.

9. What is the purpose of the `synchronized` keyword in Java?
   - A. It makes a method private and inaccessible from other threads.
   - B. It ensures that only one thread can execute a synchronized block of code at a time.
   - C. It increases the priority of a thread.
   - D. It allows multiple threads to access shared resources simultaneously without any restrictions.

**Code Questions:**

10. Given the following Java code snippet, what is the purpose of the `synchronized` block?
    ```java
    public void doSomething() {
        // ...
        synchronized (this) {
            // Critical section
        }
        // ...
    }
    ```
   - A. To make the `doSomething` method synchronized.
   - B. To prevent other threads from accessing the critical section simultaneously.
   - C. To speed up the execution of the method.
   - D. To lock the entire object.

11. In a Java application, you have a list of tasks to execute concurrently. Which concurrency construct (Executor, Thread, or Callable) would you use, and why?

12. Write a Java code snippet using the `ExecutorService` framework to execute two `Runnable` tasks concurrently.