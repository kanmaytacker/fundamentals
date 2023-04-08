# Queries

## Built-in Functions

1. Get all batches that have started on a Sunday

```sql
SELECT 
    id, name
FROM
    batches
WHERE
    DAYNAME(start_date) = 'Sunday';
```

2. Get all batches that have been running for more than 10 years

```sql
SELECT 
    id, name, start_date
FROM
    batches
WHERE
	(DATEDIFF(NOW(), start_date) / 365) > 10;
```
3. Print the name and the instructor's id for each batch. If no instructor is assigned, print `NO INSTRUCTOR`.

```sql
SELECT
    name, IFNULL(instructor_id, 'NO INSTRUCTOR')
FROM
    batches;
```

4. Print the name and IQ of each student. If the IQ of the student is less than 100, print `LOW IQ` instead.

```sql
SELECT 
    first_name, last_name, IF(iq < 100, 'LOW IQ', iq)
FROM
    students;
```

5. For each student print the name and their IQ category.

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

## Aggregate functions

1. Get the total number of batches taught by each instructor.

```sql
SELECT 
    i.first_name, COUNT(b.id)
FROM
    instructors i
        LEFT JOIN
    batches b ON i.id = b.instructor_id
GROUP BY i.id;
```

2. Find the average IQ of students in batches with batch ID `1` and `2`.

```sql
SELECT 
    batch_id, AVG(iq)
FROM
    students
WHERE batch_id IN (1, 2)
GROUP BY batch_id;
```

3. Find count of students that are part of batches that have average IQ greater than `120`.

```sql
SELECT 
    batch_id, AVG(iq) as avg_iq, COUNT(iq)
FROM
    students
GROUP BY batch_id
HAVING avg_iq > 130;
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
