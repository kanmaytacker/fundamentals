# Polymorphism

## What is Polymorphism?

Polymorphism is one of the main aspects of Object-Oriented Programming(OOP). The word polymorphism can be broken down into “Poly” and “morphs”, as “Poly” means many and “Morphs” means forms. In simple words, we can say that ability of a message to be represented in many forms.

Polymorphism is often referred to as the third pillar of object-oriented programming, after encapsulation and inheritance. Polymorphism is a Greek word that means "many-shaped" and it has two distinct aspects:

* At run time, objects of a derived class may be treated as objects of a base class in places such as method parameters and collections or arrays. When this polymorphism occurs, the object's declared type is no longer identical to its run-time type
* Base classes may define methods, and derived classes can override them, which means they provide their own definition and implementation. At run-time, when client code calls the method, the CLR looks up the run-time type of the object, and invokes that override of the virtual method. In your source code you can call a method on a base class, and cause a derived class's version of the method to be executed.

Polymorphism in Java can be achieved in two ways i.e., method overloading and method overriding.

Polymorphism in Java is mainly divided into two types.

* Compile-time polymorphism
* Runtime polymorphism

Compile-time polymorphism can be achieved by method overloading, and Runtime polymorphism can be achieved by method overriding.

### Subtyping

Subtyping is a concept in object-oriented programming that allows a variable of a base class to reference a derived class object. This is called polymorphism, because the variable can take on many forms. The variable can be used to call methods that are defined in the base class, but the actual implementation of the method is defined in the derived class.

For example, the following is our User class:

```java
public class User {
    private String name;
    private String email;
}
```

The user class is extended by the Student class:

```java
public class Student extends User {
    private String batchName;
    private Integer psp;
}
```

The Student class inherits the name and email properties from the User class. The Student class also has its own properties batchName and psp. The Student class can be used in place of the User class, because the Student class is a subtype of the User class. The following is an example of how this works:

```java
User user = new Student();
```

### Method Overloading

Method overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.

Let's take an example of a class that has two methods having the same name but different in parameters.

```java
public class User {
    private String name;
    private String email;

    public void printUser() {
        System.out.println("Name: " + name + ", Email: " + email);
    }

    public void printUser(String name, String email) {
        System.out.println("Name: " + name + ", Email: " + email);
    }
}
```

In the above example, the class has two methods with the same name printUser but different in parameters. The first method has no parameters, and the second method has two parameters. This is called method overloading.

**The compiler distinguishes these two methods by the number of parameters in the list and their data types. The return type of the method does not matter.**

### Method Overriding

Runtime polymorphism is also called Dynamic method dispatch. Instead of resolving the overridden method at compile-time, it is resolved at runtime.

Here, an overridden child class method is called through its parent's reference. Then the method is evoked according to the type of object. In runtime, JVM figures out the object type and the method belonging to that object.

Runtime polymorphism in Java occurs when we have two or more classes, and all are interrelated through inheritance. To achieve runtime polymorphism, we must build an "IS-A" relationship between classes and override a method.

If a child class has a method as its parent class, it is called method overriding.

If the derived class has a specific implementation of the method that has been declared in its parent class is known as method overriding.

Rules for overriding a method in Java
* There must be inheritance between classes.
* The method between the classes must be the same(name of the class, number, and type of arguments must be the same).

Let's add a method to our User class:

```java
public class User {
    private String name;
    private String email;

    public void printUser() {
        System.out.println("Name: " + name + ", Email: " + email);
    }
}
```

Now, let's add a method to our Student class:

```java
public class Student extends User {
    private String batchName;
    private Integer psp;

    @Override
    public void printUser() {
        System.out.println("Name: " + name + ", Email: " + email + ", Batch: " + batchName + ", PSP: " + psp);
    }
}
```

In the above example, we have added a method to the Student class that overrides the method in the User class. The Student class has a method with the same name and parameters as the User class. The Student class method has an additional print statement that prints the batchName and psp properties.

The @Override annotation is optional, but it is a good practice to use it. It is used to ensure that the method is actually being overridden. If the method is not being overridden, the compiler will throw an error.

### Advantages of Polymorphism
* Code reusability is the main advantage of polymorphism; once a class is defined, it can be used multiple times to create an object.
* In compile-time polymorphism, the readability of code increases, as nearly similar functions can have the same name, so it becomes easy to understand the functions.
* The same method can be created in the child class as in the parent class in runtime polymorphism.
* Easy to debug the code. You might have intermediate results stored in arbitrary memory locations while executing code, which might get misused by other parts of the program. Polymorphism adds necessary structure and regularity to computation, so it is easier to debug.

### Problems with Polymorphism
* Implementing code is complex because understanding the hierarchy of classes and its overridden method is quite difficult.
* Problems during downcasting because implicitly downcasting is not possible. Casting to a child type or casting a common type to an individual type is known as downcasting.
* Sometimes, when the parent class design is not built correctly, subclasses of a superclass use superclass in unexpected ways. This leads to broken code.
* Runtime polymorphism can lead to the real-time performance issue (during the process), it basically degrades the performances as decisions are taken at run time because, machine needs to decide which method or variable to invoke


## Interface

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

## Reading List
* [Duck Typing](https://realpython.com/lessons/duck-typing/#:~:text=Duck%20typing%20is%20a%20concept,a%20given%20method%20or%20attribute.)
* [OOP in Python](https://gist.github.com/kanmaytacker/e6ed49131970c67588fba9164fbc45d4)