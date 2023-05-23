# Generics and Exceptions Worksheet 

## Question 1
Today, we want to create a class called `Pair` which stores two values i.e. left and right. Let us start with a simple pair where both the values are of the String type. You should be able to create a pair of Strings and access the left and right values.

```java
```

## Question 2

The `Pair` class we created in the previous question is not very useful because it can only store two Strings. Let us make it more generic by using generics. Modify the `Pair` class so that it can store any 
type of values. For now, let us assume that the left and right values are of the same type.

```java
```

## Question 3

Let us now modify the `Pair` class so that it can store two values of different types. For example, we should be able to create a pair of String and Integer. Modify the `Pair` class so that it can store two values of different types.

```java
```

## Question 4

Let us create a utility method that takes a `Pair` as input and returns a `Pair` with the left and right values swapped. For example, if the input is a `Pair` with left value as "Hello" and right value as "World", the output should be a `Pair` with left value as "World" and right value as "Hello". 

```java
```

## Question 5

At the moment, users can pass null values to the `Pair` constructor. Let us modify the `Pair` class so that it throws an exception if the left or right value is null. 

```java
```

## Question 6

Instead of using a generic exception, let us create a custom exception called `NullValueException` and throw that exception if the left or right value is null. 

```java
```

```java
```

## Question 7

Create a client class and handle the exception thrown by the `Pair` class. 
If the exception is thrown, print the exception message to the console. 

```java
```


