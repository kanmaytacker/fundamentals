# Atomic integers and generics recap

Hello everyone 👋,

Today we entered the world of advanced Java concepts. We started with atomic integers and then moved on to generics. Let us recap what we learnt today.

*💣 Atomic integers*

- Atomic data structures ensure thread safety by making sure that the operations on them are atomic i.e. they are not interrupted by other threads and are executed as a single unit.
- Atomic integers are a special type of atomic data structures that can be used to store integers and have methods like  `incrementAndGet()`, `decrementAndGet()`, `getAndAdd()`, etc. which can be used to perform atomic operations on them.
- Atomic integers do not require any explicit locking and are more efficient than using `synchronized` blocks.

*🔢 Adder-subtractor problem*

- We solved the adder-subtractor problem using atomic integers. Our previous implementation had multiple operations being performed to add or subtract a number. 
- The count class had a `value` variable which was being modified. We replaced this variable with an atomic integer and required to create a new instance of the atomic integer.
- We replaced the update operations with atomic integers and used the `getAndAdd(index)` and `getAndDecrement(-index)` methods to perform the same operations in a single step.

*🚀 Lock-free programming and CAS*

- Atomic integers use lock-free programming to ensure thread safety. Lock-free programming is a programming paradigm where the threads do not wait for each other and do not use locks to ensure thread safety.
- Locks cause high contention and can lead to deadlocks. Lock-free programming is more efficient than using locks since the threads do not compete with each other.
- CAS or Compare-and-swap is a special instruction that is used to implement lock-free programming. It is an atomic instruction that compares the current value of a variable with an expected value. If the values do not match, it fails.
- The failed CAS instruction is retried until it succeeds.
- CAS and other atomic instructions are implemented using hardware instructions and are more efficient than using locks.
- Lock free programming is not always possible. It is not possible to implement lock-free programming for operations that require multiple steps or have complex logic such as dependency on other variables.

*🥔 Generics*
- Generics allow us to create classes that can be used with different types of values. For example, we can create a `Pair` class that can be used to store two values of any type.
- Generics are an example of parametric polymorphism.
- To create a generic class, we need to specify a placeholder type. We can use any name for the placeholder type. The placeholder type is specified using angle brackets like this: `class Pair<TYPE>`.
- To create an instance of a generic class, we need to specify the type parameter which is the actual type that will be used in place of the placeholder type. For example, to create a `Pair` of `String`s, we need to specify the type parameter as `Pair<String>`.

*🤔 Type erasure and type inference*
- At compile time, the compiler checks for type safety so that mismatched types are caught at compile time such as trying to create add a `String` to a `Pair<Integer>`.
- Once the code is compiled, the type parameters are erased and the code is converted to use `Object` types or raw types. This is called type erasure. This is done to maintain backward compatibility with older versions of Java and to avoid the overhead of storing the type parameters.
- At runtime, the type is figured out using type inference. Type inference uses reflection, type tokens and other techniques to figure out the type of the raw type.
