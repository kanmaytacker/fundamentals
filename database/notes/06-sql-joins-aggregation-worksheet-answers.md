# Queries

## Joins

1. Get all batch names along with their instructor names.

```sql
SELECT 
    b.name, i.first_name, i.last_name
FROM
    batches b
        JOIN
    instructors i ON b.instructor_id = i.id;
```

2. Get all students along with their batch names if present else `NULL`.

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        LEFT JOIN
    batches b ON s.batch_id = b.id;
```
3. Get all students along with their batch names. Also, fetch all the batches which have no students.

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        RIGHT JOIN
    batches b ON s.batch_id = b.id
```
4. Get all the combinations of batches and instructors.

```sql
SELECT 
    b.name, i.first_name, i.last_name
FROM
    batches b, instructors i
```
5. Get all students with their instructors. If a student has no instructor, then show `NULL` for the instructor's name.

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

## Aggregation
1. Get the maximum IQ in all students (Try without aggregation first).

```sql
SELECT 
    first_name, iq
FROM
    students
ORDER BY iq DESC
LIMIT 1;
```

2. Get the maximum IQ in all students (With aggregation).

```sql
SELECT 
    MAX(IQ) AS 'IQ'
FROM
    students;
```

3. Get the oldest batch from the batches table.

```sql
SELECT 
    MIN(start_date) AS 'start date'
FROM
    batches;
```

4. Fetch the number of batches that start with the word `Jedi`.

```sql
SELECT 
    COUNT(id)
FROM
    batches
WHERE
    name LIKE 'Jedi%';
```

5. Get the average IQ of all students (Without using `AVG`)

```sql
SELECT 
    SUM(iq) / COUNT(iq) as 'Average IQ'
FROM
    students;
```

6. Get the average IQ of students in all batches.

```sql
SELECT 
    AVG(IQ) AS 'IQ'
FROM
    students
WHERE
    batch_id IS NOT NULL;
```
7. Find the average IQ of students in each batch.

```sql
SELECT 
    batch_id, AVG(iq)
FROM
    students
GROUP BY batch_id;
```

8. Find the total number of students in each batch.

```sql
SELECT 
	b.name, COUNT(s.id)
FROM
    batches b
        LEFT JOIN
    students s ON b.id = s.batch_id
GROUP BY b.id;
```

9. Get the total number of batches taught by each instructor.

```sql
SELECT 
    i.first_name, COUNT(b.id)
FROM
    instructors i
        LEFT JOIN
    batches b ON i.id = b.instructor_id
GROUP BY i.id;
```

10. Find the average IQ of students in batches with batch ID `1` and `2`.

```sql
SELECT 
    batch_id, AVG(iq)
FROM
    students
WHERE batch_id IN (1, 2)
GROUP BY batch_id;
```

11. Find count of students that are part of batches that have average IQ greater than `120`.

```sql
SELECT 
    batch_id, AVG(iq) as avg_iq, COUNT(iq)
FROM
    students
GROUP BY batch_id
HAVING avg_iq > 130;
```