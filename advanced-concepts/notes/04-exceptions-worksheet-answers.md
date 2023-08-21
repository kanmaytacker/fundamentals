# Generics and Exceptions Worksheet Answers

## Question 1
Remember our `Pair` class from generics.
At the moment, users can pass null values to the `Pair` constructor. Let us modify the `Pair` class so that it throws an exception if the left or right value is null. 

```java
public class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Left and right values cannot be null");
        }
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
```

## Question 2

Instead of using a generic exception, let us create a custom exception called `NullValueException` and throw that exception if the left or right value is null. 

```java
public class NullValueException extends RuntimeException {
    public NullValueException(String message) {
        super(message);
    }
}
```

```java
public class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        if (left == null || right == null) {
            throw new NullValueException("Left and right values cannot be null");
        }
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
```

## Question 3

Create a client class and handle the exception thrown by the `Pair` class. 
If the exception is thrown, print the exception message to the console. 

```java
public class Client {
    public static void main(String[] args) {
        try {
            Pair<String, String> pair = new Pair<>("Hello", null);
        } catch (NullValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

## Question 4

You are very strict about greetings. You want to make sure that whenever creating a pair is done, you want to wish "Goodbye" to the user. This has to be done even if an exception is thrown. Modify the `Client` class so that it prints "Goodbye".

```java
public class Client {
    public static void main(String[] args) {
        try {
            Pair<String, String> pair = new Pair<>("Hello", null);
        } catch (NullValueException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye");
        }
    }
}
```



