# Streams Worksheet - Answers

1. Find below a list of integers. Iterate over it and print the square of each number.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
numbers.forEach(number -> System.out.println(number * number));
```

2. Find below a list of integers. Iterate over it and print every even number.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
numbers.stream().forEach(number -> {
    if (number % 2 == 0) {
        System.out.println(number);
    }
});
```

3. For the list of integers, find all the even numbers. Then, iterate over the even numbers and print each number.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
numbers.stream()
    .filter(number -> number % 2 == 0)
    .forEach(System.out::println);
```

4. For a list of integers, return a list of the squares of each number.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
List<Integer> squares = numbers.stream()
    .map(number -> number * number)
    .toList();
System.out.println(squares);
```

5. For a list of strings, return a list of the length of each string.

```java
List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
// Enter your code here
List<Integer> lengths = names.stream()
    .map(String::length)
    .toList();
```

6. For a list of strings, filter out the strings which do not start with the letter `T` and then uppercase the remaining strings.

```java
List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
// Enter your code here
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("T"))
    .map(String::toUpperCase)
    .toList();
```

7. For a list of strings, filter out the strings which do not start with the letter `T`, then uppercase the remaining strings and then sort them.

```java
List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
// Enter your code here
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("T"))
    .map(String::toUpperCase)
    .sorted()
    .toList();
```

8. For a list of integers, find the sum of all the numbers.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
int sum = numbers.stream()
    .reduce(0, (number1, number2) -> number1 + number2);
```

9. For a list of integers, find the sum of the squares of all the numbers.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
int sum = numbers.stream()
    .map(number -> number * number)
    .reduce(0, (number1, number2) -> number1 + number2);
```

10. For a list of integers, find the sum of the squares of all the even numbers.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
int sum = numbers.stream()
    .filter(number -> number % 2 == 0)
    .map(number -> number * number)
    .reduce(0, (number1, number2) -> number1 + number2);
```

11.  Given a list of numbers, find the maximum number in the list.


```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
Optional<Integer> max = numbers.stream()
    .reduce((number1, number2) -> number1 > number2 ? number1 : number2);
```

12. Given a list of numbers with duplicates, find the distinct numbers in the list.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
// Enter your code here
List<Integer> distinctNumbers = numbers.stream()
    .distinct()
    .toList();
```

13.  Given a list of numbers, find the average of all the numbers.
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Enter your code here
Double average = numbers.stream()
    .reduce(0.0, (currentAverage, number) -> (currentAverage + number) / 2.0);
```

14. Give a list of strings, find the average length of all the strings.

```java
List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
// Enter your code here
Double average = names.stream()
    .mapToInt(String::length)
    .average()
    .getAsDouble();
```

15.  Given a list of strings, find the first string that is longer than 10 characters.

```java
List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
// Enter your code here
Optional<String> firstLongName = names.stream()
    .filter(name -> name.length() > 10)
    .findFirst();
```
