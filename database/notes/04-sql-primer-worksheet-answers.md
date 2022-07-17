
# Queries

## Insert queries
1. Insert a row with all columns
```sql
    INSERT INTO students
    VALUES (1, 'Tantia', 'Tope', 't@t.com', '1234567890', 1);
```

2. Insert a row with some columns
```sql
    INSERT INTO students (first_name, last_name)
    VALUES ('Tantia', 'Tope');
```

---

## Select Queries
1. Get all students

    ```sql
    SELECT *
    FROM students;
    ```

2. Get first and last name of all students

    ```sql
    SELECT first_name, last_name
    FROM students;
    ```

3. Get first name of all students with output column name as `Student Name`
    
    ```sql
    SELECT first_name AS "Student Name"
    FROM students;
    ```
4. Get all unique addresses of all students
        
    ```sql
    SELECT DISTINCT address FROM students;
    ```
5. Get all students with ID equal to 1
    
    ```sql
    SELECT * FROM students WHERE id = 1;
    ```
6. Get all students with IQ greater than 150
    
    ```sql
    SELECT * FROM students WHERE iq > 150;
    ```
7. Get all students with IQ less than 100
    
    ```sql
    SELECT * FROM students WHERE iq < 100;
    ```
8. Get all students with IQ greater than 100 and less than150

    ```sql
    SELECT * FROM students
    WHERE iq > 100 AND iq < 150;
    ```
9. Get all students with IQ greater than 100 or less than 150
    
    ```sql
    SELECT * FROM students
    WHERE iq BETWEEN 100 AND 150;
    ```
10. Get all students with first name `Tantia`
    
    ```sql
    SELECT * FROM students WHERE first_name = 'Tantia';
    ```
11. Get all students with first name `Tantia` and last name `Tope`
    
    ```sql
    SELECT * FROM students
    WHERE first_name = 'Tantia' AND last_name = 'Tope';
    ```
12. Get all students with first name `John` or first name `Mycroft`
    
    ```sql
    SELECT * FROM students
    WHERE first_name = 'John' OR first_name = 'Mycroft';
    ```
13. Get all students with name `John Watson` or `Mycroft Holmes`
    
    ```sql
    SELECT * FROM students
    WHERE (first_name = 'John' AND last_name = 'Watson')
    OR (first_name = 'Mycroft' AND last_name = 'Holmes');
    ```
14. Get all students without the first name `John`
    
    ```sql
    SELECT * FROM students WHERE first_name <> 'John';
    ```
15. Get all students without the first name `John` or last name `Mycroft`
    
    ```sql
    SELECT * FROM students
    WHERE first_name <> 'John' AND last_name <> 'Mycroft';
    ```
16. Get all students with first name starting with `T`
    
    ```sql
    SELECT * FROM students WHERE first_name LIKE 'T%';
    ```
17. Get all students with last name ending with `walker`
    
    ```sql
    SELECT * FROM students WHERE last_name LIKE '%walker';
    ```
18. Get all students with first name containing `T`
    
    ```sql
    SELECT * FROM students WHERE first_name LIKE '%T%';
    ```
19. Get all students with last name in the format `___walker`
    ```sql
    SELECT * FROM students WHERE last_name LIKE '___walker';
    ```
20. Get all students in Jhansi and London
    
    ```sql
    SELECT * FROM students
    WHERE address IN ('Jhansi', 'London');
    ```
21. Get all students which do not have a batch id
    
    ```sql
    SELECT * FROM students WHERE batch_id IS NULL;
    ```
22. Get the first 5 students
    
    ```sql
    SELECT * FROM students LIMIT 5;
    ```
23. Get the first 5 students sorted by IQ
    
    
    ```sql
    SELECT * FROM students ORDER BY iq LIMIT 5;
    ```
24. Get the first 5 students sorted by IQ in descending order
    
    ```sql
    SELECT * FROM students ORDER BY iq DESC LIMIT 5;
    ```
25. Get the first 5 students sorted by IQ in descending order and then by first name
    
    ```sql
    SELECT * FROM students 
    ORDER BY iq DESC, first_name LIMIT 5;
    ```

---

## Update Queries

1. Update a row

    ```sql
    UPDATE students SET first_name = 'Tantia' WHERE id = 1;
    ```
2. Update a row with a condition

    ```sql
    UPDATE students SET first_name = 'Tantia' WHERE id = 1 AND first_name = 'John';
    ```

3. Update multiple columns

    ```sql
    UPDATE students SET first_name = 'Tantia', last_name = 'Tope' WHERE id = 1 AND first_name = 'John';
    ```

## Delete Queries

1. Delete a row with a condition
 
     ```sql
     DELETE FROM students
     WHERE id = 1 AND first_name = 'John';
     ```
 
2. Delete a multiple rows
 
     ```sql
     DELETE FROM students WHERE id IN (1, 2, 3);
     ```

## Joining Queries

1. Get first name and last name of all students and their batch names
    
    ```sql
    SELECT students.first_name, students.last_name, batches.name FROM students JOIN batches ON students.batch_id = batches.id;
    ```
2. Get first name and last name of all students and their instructor names
    
    ```sql
    SELECT s.first_name, s.last_name, i.first_name, b.name, i.last_name 
    FROM students s 
        JOIN batches b ON s.batch_id = b.id
        JOIN instructors i ON b.instructor_id = i.id;
    ```
