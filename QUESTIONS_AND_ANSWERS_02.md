# Java Advanced Concepts - Interview Questions and Answers

1. What is the main purpose of using generics in Java?
   - A) To improve code performance
   - B) To enable dynamic typing
   - C) To provide type safety
   - D) To reduce memory usage

2. Which collection framework interface provides dynamic resizing of arrays?
   - A) List
   - B) Set
   - C) Map
   - D) ArrayList

3. Which data structure is used by the HashSet class in Java?
   - A) Array
   - B) Linked List
   - C) Hash Table
   - D) Tree

4. In Java, which collection allows duplicate elements?
   - A) Set
   - B) Map
   - C) List
   - D) Queue

5. What is the purpose of the `Comparable` interface in Java?
   - A) To compare two objects based on their hash codes
   - B) To specify the natural ordering of objects
   - C) To provide a way to iterate over a collection
   - D) To filter elements in a collection

6. Which keyword is used to explicitly throw an exception in Java?
   - A) catch
   - B) throw
   - C) finally
   - D) throws

7. In Java, checked exceptions are subclasses of which class?
   - A) RuntimeException
   - B) Exception
   - C) Error
   - D) Throwable

8. What is the purpose of Java Reflection?
   - A) To create new objects
   - B) To access and manipulate class metadata at runtime
   - C) To handle exceptions
   - D) To generate bytecode

9. Which annotation is used to mark a method that overrides a method in a superclass?
   - A) @Override
   - B) @OverrideMethod
   - C) @Overload
   - D) @Overridden

10. Which of the following statements about custom annotations in Java is true?
    - A) Custom annotations can only be used by the Java standard library.
    - B) Custom annotations are defined using the `@Annotation` keyword.
    - C) Custom annotations can have runtime retention.
    - D) Custom annotations can be used to define new data types.


11. Which interface in the Java Collections Framework provides a way to store elements as key-value pairs?
   - A) List
   - B) Set
   - C) Map
   - D) Collection

12. In Java, which collection class is synchronized and suitable for multithreaded applications?
   - A) ArrayList
   - B) HashSet
   - C) ConcurrentHashMap
   - D) TreeMap

13. What is the key difference between ArrayList and LinkedList in Java?
   - A) ArrayList is faster for random access, while LinkedList is faster for insertions and deletions.
   - B) ArrayList allows duplicate elements, while LinkedList does not.
   - C) ArrayList uses a doubly-linked list, while LinkedList uses a singly-linked list.
   - D) ArrayList is an interface, while LinkedList is a concrete class.

14. In Java, what does the wildcard character "?" represent in the context of generics?
   - A) An unknown data type
   - B) A wildcard character
   - C) An exception
   - D) A generic class

15. Which method in the `Collections` class is used to sort a List in natural order?
   - A) `sort()`
   - B) `order()`
   - C) `arrange()`
   - D) `arrangeInOrder()`

16. In Java, which keyword is used to specify that a method can throw multiple exceptions?
   - A) catch
   - B) throw
   - C) throws
   - D) try

17. What is the purpose of the `getClass()` method in Java reflection?
   - A) To create a new class instance
   - B) To retrieve the runtime class of an object
   - C) To throw a ClassNotFoundException
   - D) To invoke a method on an object

18. Which annotation is used to suppress compiler warnings in Java?
   - A) @SuppressWarnings
   - B) @Override
   - C) @Deprecated
   - D) @SafeVarargs

19. What is the difference between checked and unchecked exceptions in Java?
   - A) Checked exceptions are caught at compile time, while unchecked exceptions are caught at runtime.
   - B) Checked exceptions are subclasses of RuntimeException, while unchecked exceptions are not.
   - C) Checked exceptions are more severe than unchecked exceptions.
   - D) Checked exceptions cannot be caught using try-catch blocks.

20. Which Java annotation is used to mark a class as serializable?
    - A) @Serializable
    - B) @Serial
    - C) @SerializableClass
    - D) @SerializableObject


21. Implement a generic method in Java that counts the number of occurrences of a specific element in an array.

22. Create a generic class called `Pair` that can store two different types of values. Write a Java program to demonstrate its usage.

23. Write a Java program that uses reflection to create an instance of a class dynamically and invokes one of its methods.

24. Create a custom annotation called `@LogMethod` that can be used to annotate methods in a Java class. Write a Java program that uses reflection to check if a method is annotated with `@LogMethod` and logs a message when the method is called.

25. Write Java code to create a generic method that swaps two elements in an array.

26. Implement a custom generic class called `Stack` that supports push and pop operations. Use generics to allow the stack to store elements of any data type.

27. Create a custom exception class called `InvalidAgeException` that extends `Exception`. Write a Java program that throws this exception when the age of a person is less than 18.

28. Write a Java program that uses reflection to inspect the methods of a given class and prints their names and parameter types.

---
## Answers

1. C - To provide type safety
2. D - ArrayList
3. C - Hash Table
4. C - List
5. B - To specify the natural ordering of objects
6. B - throw
7. B - Exception
8. B - To access and manipulate class metadata at runtime
9. A - @Override
10. C - Custom annotations can have runtime retention.
11. C - Map
12. C - ConcurrentHashMap
13. A - ArrayList is faster for random access, while LinkedList is faster for insertions and deletions.
14. A - An unknown data type
15. A - sort()
16. C - throws
17. B - To retrieve the runtime class of an object
18. A - @SuppressWarnings
19. A - Checked exceptions are caught at compile time, while unchecked exceptions are caught at runtime.
20. D - @SerializableObject

### 21. Implement a generic method in Java that counts the number of occurrences of a specific element in an array.

```java
public class Main {
    public static <T> int countOccurrences(T[] array, T element) {
        int count = 0;
        for (T e : array) {
            if (e.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        String[] words = {"apple", "banana", "apple", "orange", "apple", "pear"};

        System.out.println(countOccurrences(numbers, 1));
        System.out.println(countOccurrences(words, "apple"));
    }
}
```

### 22. Create a generic class called `Pair` that can store two different types of values. Write a Java program to demonstrate its usage.

```java
public class Pair<LEFT, RIGHT> {
      private LEFT left;
      private RIGHT right;
   
      public Pair(LEFT left, RIGHT right) {
         this.left = left;
         this.right = right;
      }
   
      public LEFT getLeft() {
         return left;
      }
   
      public void setLeft(LEFT left) {
         this.left = left;
      }
   
      public RIGHT getRight() {
         return right;
      }
   
      public void setRight(RIGHT right) {
         this.right = right;
      }
   
      @Override
      public String toString() {
         return "Pair{" +
                  "left=" + left +
                  ", right=" + right +
                  '}';
      }
}
```

### 23. Write a Java program that uses reflection to create an instance of a class dynamically and invokes one of its methods.

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.Date");
        Object object = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("toString");
        System.out.println(method.invoke(object));
    }
}
```

### 24. Create a custom annotation called `@LogMethod` that can be used to annotate methods in a Java class. Write a Java program that uses reflection to check if a method is annotated with `@LogMethod` and logs a message when the method is called.

```java
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogMethod {
}

class Test {
    @LogMethod
    public void testMethod() {
        System.out.println("testMethod() called");
    }
}
```

### 25. Write Java code to create a generic method that swaps two elements in an array.

```java
public class Main {
   public static <T> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }
}
```

### 26. Implement a custom generic class called `Stack` that supports push and pop operations. Use generics to allow the stack to store elements of any data type.

```java

public class Stack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
```

### 27. Create a custom exception class called `InvalidAgeException` that extends `Exception`. Write a Java program that throws this exception when the age of a person is less than 18.

```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be greater than 18");
        }
        this.name = name;
        this.age = age;
    }
}
```

### 28. Write a Java program that uses reflection to inspect the methods of a given class and prints their names and parameter types.

```java

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.Date");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getType());
            }
        }
    }
}
```

---

