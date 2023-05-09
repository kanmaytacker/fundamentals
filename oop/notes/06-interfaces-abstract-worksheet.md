# Interfaces and Abstract Classes Worksheet

# Question 1
What are the two things that a class encapsulates?

## Answer
```
```

# Question 2
What do you do if there is state duplicated across multiple classes?

e.g. 

```java
class Car {

    // Some common state
    String make;
    String model;
    int year;
    String colour;
    int mileage;
    int price;

    // Some specific state
    int numberOfDoors;
    int numberOfSeats;
    CarType carType;

}

class Bike {

    String make;
    String model;
    int year;
    String colour;
    int mileage;
    int price;

    int numberOfGears;
    int wheelSize;
    BikeType bikeType;
}
```

## Answer
```
```

```java
```

# Question 3
What do you do if there is behaviour duplicated across multiple classes?
The classes have no state as of now.

e.g. 

```java
class Car {

    // Some common behaviour
    void start() {
        // ...
    }

    void stop() {
        // ...
    }

    void accelerate() {
        // ...
    }

    void brake() {
        // ...
    }

    // Some specific behaviour
    void openBoot() {
        // ...
    }

    void closeBoot() {
        // ...
    }
    
}

class Bike {

    void start() {
        // ...
    }

    void stop() {
        // ...
    }

    void accelerate() {
        // ...
    }

    void brake() {
        // ...
    }

    // Some specific behaviour
    void sideStandUp() {
        // ...
    }

    void sideStandDown() {
        // ...
    }
}
```

## Answer
```
```

```java
```

# Question 4
What would you do if some methods in the interface have the same implementation?

e.g. 

There is a method `go()` which calls `start()`, `accelerate()` and `brake()` in that order.
This is the same for all vehicles.

## Answer
```
```

```java
```

# Question 5
What would you do if the classes have some common state and some common behaviour?

## Answer
```
```

```java

```


