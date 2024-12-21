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
