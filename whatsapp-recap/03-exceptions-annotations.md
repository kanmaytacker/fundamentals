# Exceptions and Annotations recap

👋 Hey everyone. Today was the last session of LLD Module 1 and I hope you have enjoyed the module so far.
Things are going to get more interesting from here on. We will be building a lot of things in the coming modules.

Today we covered exception handling and annotations. As I mentioned, exception handling is a very underrated topic and also extremely misunderstood. First, we covered the basics of such as what are exceptions, different types of exceptions and the associated keywords. Then we covered the best practices of exception handling. Finally, we covered annotations and how they are used in Java.

*🚦 Exceptions*
- Exceptions are events that occur during the execution of programs that disrupt the normal flow of instructions.
- They are used to handle errors and other exceptional events that occur during the execution of a program.
- There are two types of exceptions: checked and unchecked. A checked exception is an exception that is checked (notified) by the compiler at compilation-time, these are also called compile-time exceptions.
- On the other hand, an unchecked exception is an exception that is not checked (not notified) by the compiler at compilation-time, these are also called runtime exceptions. 
- You can raise an exception by creating a new object of the exception class and throwing it using the throw keyword.

*🚧 Exception Handling*
- The simplest way to handle an exception is to delegate the responsibility of handling it to the caller method. This is called propagation of exception. You can use the throws keyword at the method signature to do so.
- You can also handle the exception yourself using the try-catch block. The try block contains the code that might throw an exception and the catch block contains the code that handles the exception.
- You can also use the finally block to execute a piece of code regardless of whether an exception is thrown or not.

*🥁 Golden rules of exception handling*
- Always throw a custom or the most specific exception possible.
- Always catch the most specific exception possible.
- Never swallow an exception. Swallowing an exception means that you catch it and do nothing with it

*📌 Annotations*
- Annotations decorate code with additional information or add unrelated functionality to the code.
- Meta-annotations are annotations that can be used to annotate other annotations. For example, the @Target annotation is used to annotate other annotations to specify where they can be used.
- General-purpose are further divided into three categories: marker annotations, single-value annotations and full annotations. Marker annotations are annotations that do not have any members. For example, the @Override annotation is a marker annotation. They provide information to the compiler. 
- Single and full annotations are annotations that have members. For example, the @SuppressWarnings and @AllArgsConstructor are such examples.