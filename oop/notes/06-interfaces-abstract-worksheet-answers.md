# Interfaces and Abstract Classes Worksheet

# Question 1
What are the two things that a class encapsulates?

## Answer
```
State and behaviour
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
Extract the common state into a separate class and have the other classes extend it
```

```java
class Vehicle {

    String make;
    String model;
    int year;
    String colour;
    int mileage;
    int price;
}

class Car extends Vehicle {

    int numberOfDoors;
    int numberOfSeats;
    CarType carType;
}

class Bike extends Vehicle {

    int numberOfGears;
    int wheelSize;
    BikeType bikeType;
}
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
Extract the common behaviour into an interface and have the other classes implement it
```

```java
interface Vehicle {

    void start();

    void stop();

    void accelerate();

    void brake();
}

class Car implements Vehicle {

    @Override
    void start() {
        // ...
    }

    @Override
    void stop() {
        // ...
    }

    @Override
    void accelerate() {
        // ...
    }

    @Override
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

class Bike implements Vehicle {

    @Override
    void start() {
        // ...
    }

    @Override
    void stop() {
        // ...
    }

    @Override
    void accelerate() {
        // ...
    }

    @Override
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

# Question 4
What would you do if some methods in the interface have the same implementation?

e.g. 

There is a method `go()` which calls `start()`, `accelerate()` and `brake()` in that order.
This is the same for all vehicles.

## Answer
```
Use a default method
```

```java
interface Vehicle {

    void start();

    void stop();

    void accelerate();

    void brake();

    default void go() {
        start();
        accelerate();
        brake();
    }
}
```

# Question 5
What would you do if the classes have some common state and some common behaviour?

## Answer
```
Create an abstract class with the common state and behaviour and have the other classes extend it
```

```java
abstract class Vehicle {

    String make;
    String model;
    int year;
    String colour;
    int mileage;
    int price;

    abstract void start();

    abstract void stop();

    abstract void accelerate();

    abstract void brake();

    void go() {
        start();
        accelerate();
        brake();
    }
}

class Car extends Vehicle {

    int numberOfDoors;
    int numberOfSeats;
    CarType carType;

    public Car(String make, String model, int year, String colour, int mileage, int price, int numberOfDoors, int numberOfSeats, CarType carType) {
        super(make, model, year, colour, mileage, price);
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.carType = carType;
    }

    @Override
    void start() {
        // ...
    }

    @Override
    void stop() {
        // ...
    }

    @Override
    void accelerate() {
        // ...
    }

    @Override
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

class Bike extends Vehicle {

    int numberOfGears;
    int wheelSize;
    BikeType bikeType;

    public Bike(String make, String model, int year, String colour, int mileage, int price, int numberOfGears, int wheelSize, BikeType bikeType) {
        super(make, model, year, colour, mileage, price);
        this.numberOfGears = numberOfGears;
        this.wheelSize = wheelSize;
        this.bikeType = bikeType;
    }

    @Override
    void start() {
        // ...
    }

    @Override
    void stop() {
        // ...
    }

    @Override
    void accelerate() {
        // ...
    }

    @Override
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


