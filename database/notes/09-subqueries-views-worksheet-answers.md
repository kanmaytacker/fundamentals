# Sub-queries and views worksheet
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