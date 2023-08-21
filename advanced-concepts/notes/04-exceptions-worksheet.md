# Generics and Exceptions Worksheet 

## Question 1
Remember our `Pair` class from generics.
At the moment, users can pass null values to the `Pair` constructor. Let us modify the `Pair` class so that it throws an exception if the left or right value is null. 

```java

```

## Question 2

Instead of using a generic exception, let us create a custom exception called `NullValueException` and throw that exception if the left or right value is null. 

```java

```

```java

```

## Question 3

Create a client class and handle the exception thrown by the `Pair` class. 
If the exception is thrown, print the exception message to the console. 

```java

```

## Question 4

You are very strict about greetings. You want to make sure that whenever creating a pair is done, you want to wish "Goodbye" to the user. This has to be done even if an exception is thrown. Modify the `Client` class so that it prints "Goodbye".

```java

```



