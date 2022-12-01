# Interfaces, Abstract Classes, and Static Methods

## Interfaces

An interface is a reference type in Java. It is similar to a class, but it cannot be instantiated. It can contain only constants, method signatures, default methods, static methods, and nested types. Method bodies exist only for default methods and static methods.

It can be thought of as a blueprint of behavior. It is used to achieve abstraction and multiple inheritance in Java.

### Why use an interface?

* It is used to achieve abstraction.
* Due to multiple inheritance, it can achieve loose coupling.
* Define a common behavior for unrelated classes.

### How to create an interface?

Let us create an interface for a Person

```java
public interface Person {
    String getName();
    String getEmail();
}
```

Now let's create a class that implements the Person interface:

```java
public class User implements Person {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
```

## Abstract Classes

An abstract class is a class that is declared abstract. It may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed. When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its parent class. However, if it does not, then the subclass must also be declared abstract.

### Why use an abstract class?

* It is used to achieve abstraction.
* It can have abstract methods and non-abstract methods.
* When you don't want to provide the implementation of a method, you can make it abstract.
* When you don't want to allow the instantiation of a class, you can make it abstract.

### How to create an abstract class?

Let us create an abstract class for a Person
You can create an abstract class by using the abstract keyword.
Similarly, you can create an abstract method by using the abstract keyword.

```java
public abstract Person {

    public abstract String getName();
    public abstract String getEmail();
}
```

Now let's create a class that extends the Person abstract class:

```java
public class User extends Person {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
```

## Static Methods

Static methods are methods that can be called without creating an instance of the class. They are declared using the static keyword.

### Why use a static method?

* You can call a static method without creating an instance of the class.
* You don't need to have separate implementations of the same method for each instance of the class.

### How to create a static method?

Let us create a static method for a Person

```java
public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static String getPersonInfo(Person person) {
        return person.getName() + " " + person.getEmail();
    }
}
```

Now let's create a class that uses the static method:

```java
public class User {
    public static void main(String[] args) {
        Person person = new Person("John", "Doee");

        System.out.println(Person.getPersonInfo(person));
    }
}
```



