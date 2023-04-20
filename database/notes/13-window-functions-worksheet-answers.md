# Views and window functions

## Views

1. Create a view that shows the students and their batches.

```sql
CREATE VIEW students_and_batches AS
SELECT 
    s.id,
    s.first_name,
    s.last_name,
    s.iq,
    b.name AS batch_name
FROM
    students s
        JOIN
    batches b ON s.batch_id = b.id;
```

2. Create a view that shows the students and their batches, but only for batches that start with the word `Jedi`.

```sql
CREATE VIEW students_and_batches AS
SELECT 
    s.id,
    s.first_name,
    s.last_name,
    s.iq,
    b.name AS batch_name
FROM
    students s
        JOIN
    batches b ON s.batch_id = b.id
WHERE
    b.name LIKE 'Jedi%';
```

## Window functions

1. Print the student names along with the number of students in their batch.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    COUNT(*) OVER (PARTITION BY batch_id) AS batch_size
FROM
    students;
```

2. Print the student names along with the average IQ of their batch.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    AVG(iq) OVER (PARTITION BY batch_id) AS batch_avg_iq
FROM
    students;
```

3. Print the student names along with the maximum IQ of their batch.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    MAX(iq) OVER (PARTITION BY batch_id) AS batch_max_iq
FROM
    students;
```

4. Print the student names along with their rank based on IQ.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    RANK() OVER (ORDER BY iq) AS iq_rank
FROM
    students;
```

5. Print the student names along with their rank in their batch based on IQ.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    RANK() OVER (PARTITION BY batch_id ORDER BY iq) AS batch_iq_rank
FROM
    students;
```

6. Print the student names along with their rank in their batch based on IQ. Ties should not increase the rank.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    DENSE_RANK() OVER (PARTITION BY batch_id ORDER BY iq) AS batch_iq_rank
FROM
    students;
```

7. Print the student names along with their rank in their batch based on IQ. Ties should not be counted and broken by ID.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    batch_id,
    iq,
    ROW_NUMBER() OVER (PARTITION BY batch_id ORDER BY iq, id) AS batch_iq_rank
FROM 
    students;
```

8. Find the rank of batches based on the start date of the batch.

```sql
SELECT 
    id, 
    name,
    start_date,
    RANK() OVER (ORDER BY start_date) AS batch_rank
FROM
    batches;
```

9. Sort the instructors by the first and last name and assign them a roll number.

```sql
SELECT 
    id, 
    first_name,
    last_name,
    ROW_NUMBER() OVER (ORDER BY first_name, last_name) AS roll_number
FROM
    instructors;
```