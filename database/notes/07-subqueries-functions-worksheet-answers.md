# Queries

## Sub-queries

1. Get all the students whose IQ is greater than the average IQ.

```sql
SELECT 
    first_name, last_name, iq
FROM
    students
WHERE
    iq > (SELECT 
            AVG(iq)
        FROM
            students);
```

2. Get all the students whose IQ is greater than the highest IQ of the batch_id `2` students.

```sql
SELECT 
    *
FROM
    students
WHERE
    iq > (SELECT 
            MAX(iq)
        FROM
            students
        WHERE
            batch_id = 2);
```

3. Get all the students whose IQ is greater than `all` the IQs of the batch_id `2` students.

```sql
SELECT 
    *
FROM
    students
WHERE
    iq > ALL (SELECT 
            iq
        FROM
            students
        WHERE
            batch_id = 2);
```

4. Find all the students who are in batches that start with the word `Jedi` (Without JOIN)

```sql
SELECT 
    *
FROM
    students
WHERE
    batch_id IN (SELECT 
            id
        FROM
            batches
        WHERE
            name LIKE 'Jedi%');
```

5. Find all the students whose IQ is greater than the average IQ of their batch.

```sql
SELECT 
    *
FROM
    students;

SELECT 
    first_name, last_name, batch_id, iq
FROM
    students s
WHERE
    s.iq > (SELECT 
            AVG(iq)
        FROM
            students e
        WHERE
            e.batch_id = s.batch_id);
```

6. Get all the instructors that have at least one batch (Without using joins)

```sql
SELECT 
    *
FROM
    instructors i
WHERE
    EXISTS( SELECT 
            id
        FROM
            batches
        WHERE
            instructor_id = i.id);
```

7. Print all the names, batch ID and average IQ of the batch for each student

```sql
SELECT 
    id,
    first_name,
    last_name,
    iq,
    batch_id,
    (SELECT 
            AVG(iq)
        FROM
            students
        WHERE batch_id = s.batch_id     
		)
FROM
    students s;
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

