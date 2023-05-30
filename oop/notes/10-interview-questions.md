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

**Answer** - 
```

```

2. What would be the easiest way to fix this code?

**Answer** - 
```

```

3. What is a disadvantage of adding a `throws` declaration?
**Answer** - 
```

```

4. How can you handle the exception without making the application crash?
**Answer** - 
```

```

5. What is a problem with the above code?
**Answer** - 
```

```

6. Which exception should be caught in the `catch` block?
**Answer** - 
```

```

7. At the end of reading the file, the `Scanner` needs to be closed. How can this be done in a way that will always close the `Scanner` even if an exception is thrown?

**Answer** - 
```

```

8. Will the code below compile?

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
**Answer** - 
```

```

9. How would you handle the following requirements for the `readFile` method?
    - If the question file does not exist, print "Questions file not found" and crash the application.
    - If the answers file does not exist, print "Answers are not in yet" and continue.

**Answer** - 
```

```

10. What is the problem with handling of the `AnswersFileNotFoundException`?
**Answer** - 
```

```

---
## Memory management and strings

1. What are the primitive types in Java?
**Answer** - 
```

```

2. Where are the primitive objects stored?
**Answer** - 
```

```

3. What is the difference between a primitive type and a reference type? Where are reference types stored?
**Answer** - 
```

```

4. Why are reference types stored on the heap?
**Answer** - 
```

```

5. Where are `String` objects stored?
**Answer** - 
```

```

6. What is the benefit of string interning?
**Answer** - 
```

```

7. How do you compare two strings?
**Answer** - 
```

```

8. Why are strings called immutable?
**Answer** - 
```

```

9. What is the time complexity of this code?
```java
    String s = "";
    for (int i = 0; i < n; i++) {
        s += i;
    }
```
**Answer** - 
```

```

10. How can you improve the time complexity of the above code?
**Answer** - 
```

```