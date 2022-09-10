# Code snippets across topics

## Bank transfers in procedural and object-oriented programming
* [Procedural programming](../code/procedural_transfer.py)
* [Object-oriented programming](oop/src/main/java/com/scaler/lld/basics/OopBankAccount.java)
* [Unit test](oop/src/test/java/com/scaler/lld/basics/OopBankAccountTest.java)

## Object-oriented programming
### Encapsulation
* [Default constructor](https://github.com/kanmaytacker/fundamentals/blob/oop-default-ctor/oop/code/oop/src/main/java/com/scaler/lld/scaler/Student.java)
  * [Unit test](https://github.com/kanmaytacker/fundamentals/blob/oop-default-ctor/oop/code/oop/src/test/java/com/scaler/lld/scaler/StudentTest.java)
* [Parametrised constructor](https://github.com/kanmaytacker/fundamentals/blob/oop-para-ctor/oop/code/oop/src/main/java/com/scaler/lld/scaler/Student.java)
  * [Unit test](https://github.com/kanmaytacker/fundamentals/blob/oop-para-ctor/oop/code/oop/src/test/java/com/scaler/lld/scaler/StudentTest.java)

### Inheritance
* [User - Parent class](https://github.com/kanmaytacker/fundamentals/blob/oop-inheritance/oop/code/oop/src/test/java/com/scaler/lld/scaler/StudentTest.java)
* [Student - Child class](https://github.com/kanmaytacker/fundamentals/blob/oop-inheritance/oop/code/oop/src/main/java/com/scaler/lld/scaler/Student.java)
* [Unit Test](https://github.com/kanmaytacker/fundamentals/blob/oop-inheritance/oop/code/oop/src/test/java/com/scaler/lld/scaler/StudentTest.java)

### Polymorphism
* [Mentor class](https://github.com/kanmaytacker/fundamentals/tree/master/oop/code/oop/src/main/java/com/scaler/lld/scaler)
* [Subtyping - Mentor and Student as User](https://github.com/kanmaytacker/fundamentals/blob/master/oop/code/oop/src/main/java/com/scaler/lld/App.java#L18)
* [Method overloading - `printInfo`](https://github.com/kanmaytacker/fundamentals/blob/master/oop/code/oop/src/main/java/com/scaler/lld/scaler/User.java#L26-L31)
* [Method overriding - Overriding `printInfo` in Student](https://github.com/kanmaytacker/fundamentals/blob/master/oop/code/oop/src/main/java/com/scaler/lld/scaler/Student.java#L34)

## SOLID principles
* [Bird - v0](https://github.com/kanmaytacker/fundamentals/blob/bird-v0/oop/code/oop/src/main/java/com/scaler/lld/bird/Bird.java)
* `Bird - v1 - After fixing SRP and OCP`
  * [Bird Class](../code/oop/src/main/java/com/scaler/lld/bird/Bird.java)
  * [Parrot/Sparrow child classes](oop/src/main/java/com/scaler/lld/bird/Parrot.java)

### Assignment for SOLID - I
* Find where [the code](oop/src/main/java/com/scaler/lld/questions/Invoice.java) violates SRP
* Fix the code to make it adhere to SRP