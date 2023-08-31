# Generics and collections recap

Hey everyone 👋,

Today we continued our discussion on generics and looked at generics at a method level along with bounded types and wildcards. We also looked at the different types of collections in Java and how to use them.
Let us recap what we learnt today.

*🔢 Generics at a method level*

- Generics at method require us to specify the placeholder type parameter before the return type of the method. For example, `public <T> T getFirst(List<T> list)`.
- The placeholder can be used as the return type of the method and as the type of the parameters of the method.
- The type parameter is only available within the method and cannot be used outside the method. Other methods using the same data type will have to specify the type parameter again and can use any name for the type parameter.

*📦 Bounded types*

- Bounded types allow us to specify the upper and lower bounds of the type parameter.
- The upper bound is used to restrict the type parameter to a specific type or its subtypes. The lower bound is used to restrict the type parameter to a specific type or its superclasses. The upper bound is inclusive and the lower bound is exclusive.
- We can specify the upper bound using the `extends` keyword. For example, `public <T extends Number> T getFirst(List<T> list)`. This means that the type parameter `T` can be any type that extends `Number`.
- Similarly, we can also specify the lower bound using the `super` keyword. For example, `public <T super Integer> T getFirst(List<T> list)`. This means that the type parameter `T` can be any type that is a superclass of `Integer`.


*🐒 Wildcards*

- Wildcards allow us to specify a type parameter that can be any type. This is useful when we want to specify a type parameter that can be any type but do not want to use the raw type or do not want to specify a specific type.
- We can use the `?` operator to specify a wildcard. For example, `public void printList(List<?> list)`. Here the type parameter is a wildcard and can be any type.
- Wildcards can be used as the type of the parameters of a method but cannot be used as the return type of a method.

*📚 Collections*

- The collections framework in Java provides a set of interfaces and classes that can be used to store and manipulate collections of objects. It also contains a set of utility classes and algorithms.
- The `Collection` interface is the root interface of the collections framework. It contains methods to add, remove and iterate over elements in a collection. The `List`, `Set` and `Queue` interfaces extend the `Collection` interface.
- Another interface in the collections framework is the `Map` interface which is used to store key-value pairs. The `Map` interface is not a subtype of the `Collection` interface.

*📃 List*

- The `List` is a random access, dynamically-sized, unordered and non-unique collection of elements.
- The `ArrayList` class which uses an array to store the elements and provides an amortized constant time access to elements. It uses an array reallocation strategy to resize the array when it is full.
- A thread-safe implementation of the `List` interface is the `CopyOnWriteArrayList` class which uses a copy-on-write strategy to ensure thread safety. It creates a new copy of the array whenever an element is added or removed.
- There is also a synchronized implementation of the `List` interface called the `Vector` class which uses a synchronized block to ensure thread safety and is a legacy class.

*🏖️ Set*

- The `Set` is a sequential access, dynamically-sized, unordered and unique collection of elements.
- The most popular implementation of the `Set` interface is the `HashSet` class which uses a hash table to store the elements and provides an amortized constant time access to elements. It uses a hash function to map the elements to buckets and chaining using linked lists to handle collisions.
- There is also a LinkedHashSet class which is an ordered set. It uses a hash table and a linked list to store the elements. It uses a hash function to map the elements to buckets and a linked list to maintain the order of the elements. 

*🌲 TreeSet*
- Another popular implementation of the `Set` interface is the `TreeSet` class which uses a red-black tree to store the elements. It is a great choice for range queries and provides logarithmic time access to elements.
-  A tree set uses a comparator to compare the elements and maintain the order of the elements or relies on the natural ordering of the elements if no comparator is specified.
- A thread-safe implementation of the `Set` interface is the `CopyOnWriteArraySet` class which uses a copy-on-write strategy to ensure thread safety.

*🪞 Comparable and Comparator*

- The `Comparable` interface is used to provide a default or natural ordering to classes. It contains a single method called `compareTo()` which takes another object of the same type as a parameter and returns an integer value.
- The `Comparator` interface is used to provide a custom ordering to classes. It contains a single method called `compare()` which takes two objects of the same type as parameters and returns an integer value. The values returned by the `compare()` method are the same as the `compareTo()` method.
- The `Comparator` interface is useful when we want to provide multiple orderings to a class or when we want to provide an ordering to a class that we do not own.