# Object-oriented programming

The goal of this worksheet to create a few classes for Scaler's entities using OOP concepts. Let us focus on the most
important entity: the student. Some requirements:

1. ~~A student should have a name, email, batch name and PSP.~~
2. ~~A student should also have a status reflecting whether they are active or not. Some possible statuses are: active,
   paused, completed etc.~~
3. ~~A student should have a method to change their status.~~
4. ~~The PSP of the student should be private.~~
5. ~~The status should be active by default.~~
6. ~~The PSP of a student should be within the range of 0 to 100. If it is not, then the object should not be created.~~

```
```

---

6. ~~Replace the status string with an enum.~~
7. ~~We want to generate a student's roll number. First, add an integer field ID to the student.~~
8. ~~Then add a method to generate the roll number by combining a prefix, batch name and ID. The prefix for all students
   is "S".~~
   S-Scaler-1

```
```

---

9. ~~Create a class for a mentor. A mentor should have an id, name, email and a list of students.~~

```
```

---

10. ~~Add a method to print the details of a user in the following format `name (email)`. For
    example, `Tantia Tope (tantia@rev.in)`~~
11. Creating a mentor with the students list is a bit cumbersome. Allow the mentor to be created without the students
    list. Set the students list to an empty list by default.
12. For a student, add a method to print the details of a student in the following format `name (email) - batchName`.
    For example, `Tantia Tope (tantia@rev.in) - Scaler Jhansi`

---

13. You have to email all the students and mentors. Create a new class for sending emails to all students and mentors.
14. Now, you also have to send SMS to all the students. How do you reduce the code duplication and enforce a contract?

