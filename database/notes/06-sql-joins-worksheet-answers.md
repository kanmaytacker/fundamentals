# Queries
1. Get all students which do not have a batch id
    
    ```sql
    SELECT * FROM students WHERE batch_id IS NULL;
    ```
2. Get the first 5 students
    
    ```sql
    SELECT * FROM students LIMIT 5;
    ```
3. Get the first 5 students sorted by IQ
    
    
    ```sql
    SELECT * FROM students ORDER BY iq LIMIT 5;
    ```
4. Get the first 5 students sorted by IQ in descending order
    
    ```sql
    SELECT * FROM students ORDER BY iq DESC LIMIT 5;
    ```
5. Get the first 5 students sorted by IQ in descending order and then by first name
    
    ```sql
    SELECT * FROM students 
    ORDER BY iq DESC, first_name LIMIT 5;
    ```

---

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

3. Get all batch names along with their instructor names.

```sql
SELECT 
    b.name, i.first_name, i.last_name
FROM
    batches b
        JOIN
    instructors i ON b.instructor_id = i.id;
```

4. Get all students along with their batch names if present else `NULL`.

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        LEFT JOIN
    batches b ON s.batch_id = b.id;
```
5. Get all students along with their batch names. Also, fetch all the batches which have no students.

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        RIGHT JOIN
    batches b ON s.batch_id = b.id
```
6. Get all the combinations of batches and instructors.

```sql
SELECT 
    b.name, i.first_name, i.last_name
FROM
    batches b, instructors i
```
7. Get all students with their instructors. If a student has no instructor, then show `NULL` for the instructor's name.

```sql
SELECT 
    s.first_name, s.last_name, i.first_name, i.last_name
FROM
    students s
        LEFT JOIN
    batches b ON s.batch_id = b.id
        LEFT JOIN
    instructors i ON b.instructor_id = i.id;
```

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
