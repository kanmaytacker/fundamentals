# Interview questions worksheet

## Exceptions 

```java
    public static void main(String[] args) {

        File file = new File("src/main/resources/test.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

    }
```

1. The above code will not compile. This is because the `Scanner` constructor throws a `FileNotFoundException`. What type of exception is this?

**Answer** - Checked exception

2. What would be the easiest way to fix this code?

**Answer** - Add a `throws` declaration to the `main` method.
```java
    public static void main(String[] args) throws FileNotFoundException {
        ...
    }
```

3. What is a disadvantage of adding a `throws` declaration?
**Answer** - The exception will be passed up the call stack until it is handled. This means that the method that calls `main` will also need to have a `throws` declaration. This will continue until the exception is handled. If the exception is not handled, the program will crash.

4. How can you handle the exception without making the application crash?
**Answer** - Surround the code with a `try`/`catch` block.
```java
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
```

5. What is a problem with the above code?
**Answer** - The `catch` block is catching all exceptions. This is bad practice as it is not clear what the problem is. It is better to catch specific exceptions. If there is another problem, such as a `NullPointerException`, it will be caught by the `catch` block and the message will be misleading.

6. Which exception should be caught in the `catch` block?
**Answer** - `FileNotFoundException`
```java
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
```

7. At the end of reading the file, the `Scanner` needs to be closed. How can this be done in a way that will always close the `Scanner` even if an exception is thrown?

**Answer** - Use a `try`/`catch`/`finally` block.
```java
    public static void main(String[] args) {
        
        Scanner scanner = null;
        try {
            File file = new File("src/main/resources/test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
```

```java
    public static void main(String[] args) {
        String questions = readFile("src/main/resources/questions.txt");
        String answers = readFile("src/main/resources/answers.txt");
    }

    private static String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String data = "";

        while (scanner.hasNextLine()) {
            data += scanner.nextLine();
        }

        return data;
    }
```

8. Will the above code compile?
**Answer** - No, the `readFile` method throws a `FileNotFoundException` but the `main` method does not handle it.

9. How would you handle the following requirements for the `readFile` method?
    - If the question file does not exist, print "Questions file not found" and crash the application.
    - If the answers file does not exist, print "Answers are not in yet" and continue.

**Answer** - There are multiple ways to do this.
- Add separate try/catch blocks for each Scanner constructor
- Create two separate methods, one for questions and one for answers
- Throw custom exceptions and handle them in the main method

```java
    public static void main(String[] args) {
        try {
            String questions = readFile("src/main/resources/questions.txt");
            String answers = readFile("src/main/resources/answers.txt");
        } catch (QuestionsFileNotFoundException e) {
            System.out.println("Questions file not found");
            throw new RuntimeException(e);
        } catch (AnswersFileNotFoundException e) {
            System.out.println("Answers are not in yet");
        }
    }

    private static String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String data = "";

        while (scanner.hasNextLine()) {
            data += scanner.nextLine();
        }

        return data;
    }
```

10. What is the problem with handling of the `AnswersFileNotFoundException`?
**Answer** - The error is being swallowed. The `main` method will continue to run as if nothing happened. This is bad practice as it is not clear that there is a problem. It is better to throw a `RuntimeException` so that the application will crash, and the problem will be clear.

---
## Memory management and strings

1. What are the primitive types in Java?
**Answer** - There are 8 primitive types in Java:
- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `boolean`
- `char`

2. Where are the primitive objects stored?
**Answer** - The primitive objects are stored on the stack. This is a small area of memory that is allocated to each thread. The stack is used to store local variables and method calls.

3. What is the difference between a primitive type and a reference type? Where are reference types stored?
**Answer** - A primitive type is a simple value, such as a number or a character. A reference type is a pointer to an object. Reference types are stored on the heap. The heap is a large area of memory that is shared between all threads. The heap is used to store objects. The object itself is stored on the heap, and the reference to the object is stored on the stack. The heap is garbage collected, which means that objects that are no longer referenced will be removed from memory.

4. Why are reference types stored on the heap?
**Answer** - Reference types are stored on the heap because they can be very large. If they were stored on the stack, the stack would quickly run out of memory. Another reason is that reference types can be shared between threads. If they were stored on the stack, they would not be accessible to other threads.

5. Where are `String` objects stored?
**Answer** - `String` objects are reference types, so they are stored on the heap. However, `String` objects are special because they are immutable. They are also stored in a special are of the heap called the intern pool or the string constant pool. When a string is created, it creates a character array and stores it in the intern pool. If another string is created with the same value, it will use the same character array. This is called string interning.

![String Interning](https://www.baeldung.com/wp-content/uploads/2021/02/stringpool.png)

6. What is the benefit of string interning?
**Answer** - String interning saves memory. If the same string is used multiple times, it will only be stored once in the intern pool. This means that if a string is used in multiple places in the application, it will only be stored once in memory.

7. How do you compare two strings?
**Answer** - You can use the `equals` method to compare two strings. This will compare the values of the strings. If you want to compare the references, you can use the `==` operator. However, due to interning, this will not always work.

8. Why are strings called immutable?
**Answer** - Strings are immutable because they cannot be changed. If you want to change a string, you have to create a new string. This is because strings are stored in the intern pool. If you change a string, it will change all references to that string. This is why strings are immutable.

9. What is the time complexity of this code?
```java
    String s = "";
    for (int i = 0; i < n; i++) {
        s += i;
    }
```
**Answer** - The time complexity of this code is O(n^2). This is because each time the string is changed, a new string is created. This means that the string is copied each time.

10. How can you improve the time complexity of the above code?
**Answer** - You can use a `StringBuilder` to improve the time complexity. A `StringBuilder` is a mutable string. It is stored on the heap, so it is not copied each time it is changed. This means that the time complexity is O(n).
```java
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
        sb.append(i);
    }
    String s = sb.toString();
```