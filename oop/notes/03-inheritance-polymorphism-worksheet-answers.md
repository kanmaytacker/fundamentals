# Object-oriented programming

The goal of this worksheet to create a few classes for Scaler's entities using OOP concepts. Let us focus on the most important entity: the student. Some requirements:
1. A student should have a name, batch name and PSP.
2. A student should also have a status reflecting whether they are active or not. Some possible statuses are: active, paused, completed etc. 
3. A student should have a method to change their status. When a student is created, their status should be active by default.
4. The PSP of the student should be private.
5. The PSP of a student should be within the range of 0 to 100. If it is not, then the object should not be created.

```java
public class Student {
    String name;
    String email;
    String batchName;
    String status;
    private int psp;


    public Student(String name, String email, String batchName, int psp) {

        if (psp < 0 || psp > 100) {
            throw new IllegalArgumentException("PSP should be between 0 and 100");
        }

        this.name = name;
        this.email = email;
        this.batchName = batchName;
        this.psp = psp;
        this.status = "active";
    }

    public void changeStatus(String status) {
        this.status = status;
    }

}
```

## Use an enum for status

```java
public enum StudentStatus {
    ACTIVE,
    PAUSED,
    COMPLETED
}
```

```java
public class Student {
    String name;
    String email;
    String batchName;
    StudentStatus status;
    private int psp;
}
```

## Generate a roll number

```java
public class Student {
    
    private static final String PREFIX = "S";

    String name;
    String email;
    String batchName;
    StudentStatus status;
    private int psp;
    private int id;

    public Student(int id, String name, String email, String batchName, int psp) {
        this.name = name;
        this.email = email;
        this.batchName = batchName;
        this.psp = psp;
        this.status = StudentStatus.ACTIVE;
        this.id = id;
    }

    private String generateRollNumber() {
        return PREFIX + batchName + id;
    }
}
```

## Create a mentor class

```java
public class Mentor {
    private int id;
    String name;
    String email;
    List<Student> students = new ArrayList<>();

    public Mentor(int id, String name, String email, List<Student> students) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.students = students;
    }
}
```

## Create the student and mentor classes using a common base class

```java
public class User {
    private int id;
    String name;
    String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
```

```java
public class Student extends User {
    private static final String PREFIX = "S";

    String batchName;
    StudentStatus status;
    private int psp;

    public Student(int id, String name, String email, String batchName, int psp) {
        super(id, name, email);
        this.batchName = batchName;
        this.psp = psp;
        this.status = StudentStatus.ACTIVE;
    }

    private String generateRollNumber() {
        return PREFIX + batchName + id;
    }
}
```

```java
public class Mentor extends User {
    List<Student> students = new ArrayList<>();

    public Mentor(int id, String name, String email, List<Student> students) {
        super(id, name, email);
        this.students = students;
    }
}
```

## Mentor constructor overloading

```java
public class Mentor extends User {
    List<Student> students = new ArrayList<>();

    public Mentor(int id, String name, String email, List<Student> students) {
        super(id, name, email);
        this.students = students;
    }

    public Mentor(int id, String name, String email) {
        super(id, name, email);
    }
}
```

## Print the details of a user - `name (email)`
```java
public class User {
    private int id;
    String name;
    String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void printDetails() {
        System.out.println(name + " (" + email + ")");
    }
}
```

## Print the details of a student - `name (email) - batchName`
```java
public class Student extends User {
    private static final String PREFIX = "S";

    String batchName;
    StudentStatus status;
    private int psp;

    public Student(int id, String name, String email, String batchName, int psp) {
        super(id, name, email);
        this.batchName = batchName;
        this.psp = psp;
        this.status = StudentStatus.ACTIVE;
    }

    private String generateRollNumber() {
        return PREFIX + batchName + id;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " (" + email + ") - " + batchName);
    }
}
```

## Email Sender to both students and mentors

```java
public class EmailSender {

    public void sendEmail(List<User> users) {
        for (User user : users) {
            System.out.println("Sending email to " + user.email);
        }
    }
}
```

## Interface for sending notifications


```java
public interface NotificationSender {
    void sendNotification(List<User> users);
}
```

```java
public class EmailSender implements NotificationSender {

    @Override
    public void sendNotification(List<User> users) {
        System.out.println("Sending email notification");
    }
}
```