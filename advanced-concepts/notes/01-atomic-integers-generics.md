# Atomic Integers and Generics
- [Atomic Integers and Generics](#atomic-integers-and-generics)
  - [Atomic integers](#atomic-integers)
    - [Motivation](#motivation)
    - [Contention](#contention)
    - [Usage](#usage)
    - [Advantages of atomic integers](#advantages-of-atomic-integers)
    - [Additional reading](#additional-reading)
  - [Generics](#generics)
    - [Generic methods](#generic-methods)
    - [Generic classes](#generic-classes)
    - [Bounded Type Parameters](#bounded-type-parameters)
    - [Wildcards](#wildcards)
    - [Additional reading](#additional-reading-1)
      - [Type Erasure](#type-erasure)
      - [Advantages of Type Erasure](#advantages-of-type-erasure)

## Atomic integers

### Motivation

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

### Usage

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

### Advantages of atomic integers

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

### Additional reading

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

## Generics

Generics were added to Java to provide compile-time type checking and removing the risk of ClassCastException that was common while working with collection classes. Before generics, we can store any type of objects in the collection, i.e., non-generic. Now generics force the java programmer to store a specific type of objects.

Generics allows us to reuse the same code with different inputs. We can use Java generics methods and classes for any type of objects. The idea is to allow type (Integer, String, … etc, and user-defined types) to be a parameter to methods, classes, and interfaces. For example, classes like HashSet, ArrayList, HashMap, etc use generics very well. We can use them for any type.

### Generic methods

We can write a single generic method declaration that can be called with arguments of different types. Based on the types of the arguments passed to the generic method, the compiler handles each method call appropriately. Following are the rules to define Generic Methods:
1. All generic method declarations have a type parameter section delimited by angle brackets (< and >) that precedes the method's return type.
2. Each type parameter section contains one or more type parameters separated by commas. A type parameter, also known as a type variable, is an identifier that specifies a generic type name.

Let us say we want to write a generic method that can print an integer, string or any other type. For this, we will use the following syntax:

```java
public static <T> void print(T t) {
    System.out.println(t);
}
```

Here, we have used the generic method print that can print any type of data. The type parameter is specified with the help of angle brackets. The type parameter section, delimited by angle brackets (< and >), follows the method name. It specifies the type parameters (also called type variables) T.

We can also use multiple type parameters in a generic method. For example:

```java
public static <T, U> void print(T t, U u) {
    System.out.println(t + " " + u);
}
```

### Generic classes

If multiple methods are using generics then we can create a generic class that can be used by all those methods. For example, we can create a generic class Pair that can store a key-value pair. We can use this class to store a pair of integers, a pair of strings, etc.

```java
public class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }
}
```

Apart from reducing type declarations, generics also allow us to create generic fields and constructors.

### Bounded Type Parameters

We can also restrict the types that can be passed to a type parameter. For example, a method that works on numbers might only want to accept instances of Number or its subclasses. This is what bounded type parameters are for.

If we want to write a method that can print the details of any type of employee, we can use the following syntax:

```java
public static <T extends Employee> void print(T t) {
    System.out.println(t);
}
```

We can also use multiple bounds on a type parameter. For example:

```java
public static <T extends Employee & Comparable<T>> void print(T t) {
    System.out.println(t);
}
```

### Wildcards

The question mark (?) represents an unknown type. The wildcard can be used in a variety of situations such as the type of a parameter, field, or local variable; sometimes as a return type (though it is better programming practice to be more specific). The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation, or a supertype.

For example, we can write a method that works on lists of any type:

```java
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
}
```

### Additional reading

The implementation of generics in Java involves a concept known as type erasure, which allows the benefits of generics to be realized without introducing significant runtime overhead.

Here's how generics are implemented in Java:

1. **Type Erasure:**
   - Generics in Java use a mechanism called "type erasure" to ensure backward compatibility with pre-existing code and to minimize the runtime overhead introduced by introducing generics.
   - During compilation, the compiler replaces type parameters (e.g., `T`, `E`) with their corresponding bound types or with `Object` if no bounds are specified. This process is known as type erasure.
   - For example, a generic class `Box<T>` would be treated as `Box` at runtime after type erasure.

2. **Type Bounds:**
   - Generics allow you to specify upper and lower bounds for type parameters using wildcards (`? extends T` and `? super T`). These bounds are enforced at compile-time to ensure type safety.
   - Type bounds help restrict the types that can be used with a generic class or method, ensuring that only compatible types are used.

3. **Type Checking and Inference:**
   - The Java compiler performs extensive type checking during compilation to ensure that the usage of generics is correct and adheres to specified type bounds.
   - Type inference allows the compiler to automatically determine the appropriate type based on the context in which a generic type is used.

4. **Type Casting and Raw Types:**
   - Type erasure can lead to situations where type information is lost at runtime. To maintain compatibility with legacy code and libraries, Java allows the use of raw types, where generic type information is ignored. However, using raw types circumvents the benefits of type safety offered by generics.
   - Explicit type casting may be necessary when working with raw types or objects of unknown generic types.

5. **Bridge Methods:**
   - To ensure compatibility between generic and non-generic code, the compiler generates bridge methods during compilation. These bridge methods help maintain polymorphism and type safety.

Here's a simplified example to illustrate generics implementation:

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(42);
        Box<String> stringBox = new Box<>("Hello");

        Integer intValue = integerBox.getValue();
        String stringValue = stringBox.getValue();

        System.out.println("Integer Value: " + intValue);
        System.out.println("String Value: " + stringValue);
    }
}
```

In this example, the generic class `Box<T>` is implemented. The type parameter `T` is replaced with its bound types during type erasure. The type safety and compile-time checking provided by generics ensure that only appropriate types are used with the `Box` class.

#### Type Erasure

Type erasure is a fundamental concept in Java's generics that allows the benefits of generics to be achieved at compile-time while minimizing the runtime overhead. It ensures compatibility with pre-existing non-generic code and prevents the creation of multiple versions of classes for each type parameter.

Let's delve into the steps that happen at compile-time and runtime when dealing with type erasure:

**Compile-Time Steps:**

1. **Declaration with Type Parameter:**
   - When you declare a generic class, interface, or method with a type parameter, such as `class Box<T>`, the type parameter `T` is used as a placeholder for a specific type.

2. **Type Checking and Constraints:**
   - The compiler performs type checking and enforces constraints specified by type bounds (`extends` and `super`) during compilation to ensure type safety.

3. **Type Erasure:**
   - After type checking, the compiler replaces all occurrences of the type parameter with its bound type or `Object` if no bounds are specified. This process is known as type erasure.
   - The actual type information associated with the type parameter is removed from the compiled bytecode.

4. **Bridge Methods Generation:**
   - To maintain compatibility between generic and non-generic code, the compiler generates bridge methods during compilation.
   - Bridge methods ensure polymorphism and type safety when overriding methods in subtypes.

**Runtime Steps:**

1. **Erased Types:**
   - At runtime, generic types are treated as their raw types due to type erasure. Raw types are classes or interfaces without type parameters.

2. **Type Casting and Type Checks:**
   - If you use a generic class or method with a specific type argument, the compiler inserts necessary type casts and checks to ensure type safety.

3. **Compatibility with Legacy Code:**
   - Type erasure allows generic code to interact seamlessly with pre-existing non-generic code and libraries.

Here's an example to illustrate type erasure:

```java
import java.util.List;

public class TypeErasureExample {
    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "World");
        List<Integer> integerList = List.of(42, 73);

        System.out.println("List Class for Strings: " + stringList.getClass());
        System.out.println("List Class for Integers: " + integerList.getClass());

        // Compile-time type checking prevents incorrect assignments
        // stringList = integerList; // Compile-time error
    }
}
```

In this example, the generic types `List<String>` and `List<Integer>` are treated as the raw type `List` at runtime due to type erasure. This is why `stringList.getClass()` and `integerList.getClass()` return the same `List` class at runtime.

Type erasure helps ensure that the compiled bytecode is compatible with pre-existing code and maintains type safety. It enables the use of generics while minimizing the impact on runtime performance. However, it's important to note that some type information is lost at runtime, and certain operations, such as reflection, may behave differently when dealing with generic types.

When referring to "specified type bounds and constraints" in the context of generics, we are talking about limitations and requirements that are defined for the types that can be used as arguments for a generic class, interface, or method. These bounds and constraints help ensure type safety and restrict the range of possible types that can be used with the generic construct.

Here are the key concepts related to specified type bounds and constraints:

1. **Type Bounds (extends and super):**
   - Generics allow you to specify bounds on the types that can be used as type arguments. These bounds define a range of acceptable types.
   - The `extends` keyword is used to specify an upper bound, indicating that the type argument must be a subtype of a certain class or interface.
   - The `super` keyword is used to specify a lower bound, indicating that the type argument must be a supertype of a certain class or interface.

```java
class Box<T extends Number> { ... } // T must be a subtype of Number
class Container<T super Integer> { ... } // T must be a supertype of Integer
```

2. **Constraints on Method Signatures:**
   - Generics can have constraints on method signatures within a generic class or interface.
   - Constraints can include rules about the relationship between the types of method parameters, return types, and type arguments.

```java
interface Processor<T extends Number> {
    double process(T value); // Constraint on method signature
}
```

3. **Type Compatibility and Inference:**
   - Specified bounds and constraints ensure that only compatible types can be used with the generic construct.
   - When using a generic class or method, the Java compiler enforces these constraints and ensures type compatibility.

```java
Box<Integer> intBox = new Box<>(42); // OK, Integer is a subtype of Number
Box<String> strBox = new Box<>("Hello"); // Compile-time error, String is not a subtype of Number
```

In summary, specified type bounds and constraints in generics define the allowable range of types that can be used with a generic construct. This helps prevent incorrect type usage, enhances type safety, and ensures that the generic code works with a limited set of compatible types.

#### Advantages of Type Erasure
Type erasure is necessary in Java's generics to ensure compatibility with existing non-generic code and libraries while minimizing the runtime overhead introduced by introducing generics.

Here are the key reasons why type erasure is necessary:

1. **Backward Compatibility:** Type erasure allows generic code to work seamlessly with pre-existing non-generic code and libraries. This is crucial for maintaining compatibility with Java's extensive ecosystem of libraries and applications that were developed before generics were introduced.

2. **Minimized Runtime Overhead:** Type erasure helps avoid the creation of specialized versions of classes for each type parameter. This minimizes the amount of bytecode generated and reduces the runtime memory overhead, making the introduction of generics less resource-intensive.

3. **Code Optimization:** By performing type erasure, the compiler can optimize code more effectively. The elimination of generic type information at runtime simplifies the execution of instructions, making the code more efficient.

4. **Type Safety at Compile Time:** Despite type erasure, generics provide type safety at compile time by enforcing type checking and constraints. This ensures that incompatible types are caught during compilation, reducing the likelihood of runtime errors.

5. **Simplicity:** Type erasure simplifies the overall language design and implementation. It allows developers to work with generics without having to manage complex interactions between specialized versions of classes.

While type erasure has some trade-offs, such as the loss of specific type information at runtime, it strikes a balance between backward compatibility, runtime efficiency, and type safety. It allows Java to provide the benefits of generics while preserving compatibility with existing codebases and optimizing runtime performance.