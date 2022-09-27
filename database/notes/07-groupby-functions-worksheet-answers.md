# Queries

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

## Built-in Functions
1. Get the average IQ of all the students rounded to the nearest integer.

```sql
SELECT 
    ROUND(AVG(iq))
FROM
    students;
```
2. Find all batches whose name is longer than 10 characters.

```sql
SELECT 
    id, name
FROM
    batches
WHERE
    LENGTH(name) > 10;
```

3. Find all batches whose name's first 10 characters contains the string `sher`

```sql
SELECT 
    id, name
FROM
    batches
WHERE
    LOCATE('sher', SUBSTR(name, 1, 10)) > 0;
```

4. Get all batches that have started on a Sunday

```sql
SELECT 
    id, name
FROM
    batches
WHERE
    DAYNAME(start_date) = 'Sunday';
```

5. Get all batches that have been running for more than 10 years

```sql
SELECT 
    id, name, start_date
FROM
    batches
WHERE
	(DATEDIFF(NOW(), start_date) / 365) > 10;
```
6. Print the name and the instructor's id for each batch. If no instructor is assigned, print `NO INSTRUCTOR`.

```sql
SELECT
    name, IFNULL(instructor_id, 'NO INSTRUCTOR')
FROM
    batches;
```

7. Print the name and IQ of each student. If the IQ of the student is less than 100, print `LOW IQ` instead.

```sql
SELECT 
    first_name, last_name, IF(iq < 100, 'LOW IQ', iq)
FROM
    students;
```

8. For each student print the name and their IQ category.

| IQ        | Category |
| --------- | -------- |
| < 100     | LOW IQ   |
| 100 - 150 | MEDIUM   |
| > 150     | HIGH     |

```sql
SELECT 
    first_name,
    last_name,
    CASE
        WHEN iq > 150 THEN 'HIGH IQ'
        WHEN iq BETWEEN 100 AND 150 THEN 'MEDIUM IQ'
        ELSE 'LOW IQ'
    END
FROM
    students;
```

