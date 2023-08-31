# SOLID Principles: Subtyping, Liskov's, Interface Segregation, Dependency Inversion

Hey there! 👋 Let's take a quick look back at our discussion on some crucial principles that guide software design. Here's a recap of what we covered:

💡 *Subtyping and Liskov's Substitution Principle:*
- Subtyping is a form of polymorphism that allows a subtype to be substituted for its supertype. It promotes code reuse and flexibility in your codebase by allowing you to create generic methods that can be used with different types of objects.
- Liskov's Substitution Principle (LSP) states that if we substitute a subtype for its supertype, the program should still work. It ensures that subtypes adhere to the expected behavior of their supertypes.
- LSP is violated when a subclass changes the behavior of its superclass in a way that breaks the contract of the superclass. This can lead to unexpected behavior and bugs in your code.

🪛 *Fixing LSP Violations:*
- LSP violations indicate badly designed class hierarchies since a subclass is forced to implement methods that are irrelevant to its purpose.
- To fix this, you have to move the methods to a more appropriate class. You can use an abstract class or interface to define the methods and have the subclasses implement them.
- Using an abstract class ties the behaviour to the class hierarchy, while using an interface allows you to decouple the behaviour from the class hierarchy.
- Always remember the example of FlyableSwimmableBird. If you start with a bird class with the fly method, the issue is not all birds fly. Creating abstract subclasses such as FlyableBird and NonFlyableBird works but what do you do when you want to add a swim method. There are birds that can do both and can do neither. 
 
🔍 *Interface Segregation Principle (ISP):*
- ISP suggests that classes should not be forced to implement interfaces they don't need. Instead, interfaces should be fine-grained and focused on specific functionalities.
- This principle helps prevent bulky interfaces where classes are compelled to implement methods that are irrelevant to their purpose. It leads to more cohesive and maintainable code.
- When designing interfaces, think about the single responsibility of each one and group related methods together.

🔗 *Dependency Inversion Principle (DIP):*
- DIP emphasizes that high-level modules should not depend on low-level modules; both should depend on abstractions. 
- By following DIP, you can achieve loose coupling and greater flexibility in your codebase. Your code will be less dependent on specific implementations, allowing you to easily swap them when necessary.
- It also aids in easier testing, maintenance, and future changes.
