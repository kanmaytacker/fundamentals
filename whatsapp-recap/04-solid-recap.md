# SOLID Principles: SRP and OCP

Hello everyone! 👋 Yesterday, we dove into the world of good software design and explored some foundational principles. Let's recap our key takeaways:

💡 What is good software?
- A good software is maintainable, extensible, and scalable.
- Maintainability is the ease with which a software can be modified, corrected, and adapted. Readability and testability are key factors in maintainability.
- Extensibility is the ease with which a software can be extended to add new features.
- Scalability is the ease with which a software can be scaled to handle increased load.

🧱 What are the SOLID principles?
- SOLID is a mnemonic acronym for five design principles intended to make object-oriented designs more understandable, flexible, and maintainable.

👨‍🏫 What is the Single Responsibility Principle?
- SRP states that every code unit should have a single responsibility, that allows for smaller, well-defined, and more maintainable code units. Modular code is easier to understand, test, and maintain.
- Understanding the responsibility of a code unit is subjective and depends on the context. Thus, it is easier to think of SRP in terms of reasons to change. A code unit should only do one thing, and thus *only have one reason to change*.
- SRP is commonly violated in large if-else blocks, monster methods and utility classes.

🚪 What is the Open-Closed Principle?
- OCP states that a software entity should be open for extension, but closed for modification. This means that we should be able to add new functionality to the class without changing the existing code.
- To add a new feature, we should ideally create a new class or method and have very little or no changes in the existing code. In doing so, we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application.
- Open-Closed Principle is commonly violated in switch statements and if-else blocks where conditional logic is implemented based on an enum or a boolean.

🪛 Fixing SRP and OCP violations
- The reason behind these violations is that we are trying to do too much in a single class. We are trying to implement multiple responsibilities in a single class.
- You can fix these violations by using inheritance and polymorphism. Break the class into a base class and subclasses where common functionality is implemented in the base class and specific functionality is implemented in the subclasses.
- Remember, you use abstract classes when you have common attributes and methods between two classes, and you use interfaces when you have common methods but no common attributes.




