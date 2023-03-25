# Introduction to SQL

SQL is a language for interacting with databases.

It is a declarative language, which means that you tell the database what you want, and the database figures out how to get it. 

We will be using MySQL where the syntax is slightly different from other SQL databases, but the concepts are the same.

1. Show all databases

```sql
SHOW DATABASES;
```

2. Create a database

```sql
CREATE DATABASE scaler;
```

3. Create a database only if it doesn't exist

```sql
CREATE DATABASE IF NOT EXISTS scaler;
```

4. Delete a database

```sql
DROP DATABASE scaler;
```

5. Delete a database only if it exists

```sql
DROP DATABASE IF EXISTS scaler;
```

6. Use a database

```sql
USE scaler;
```

7. Show all tables

```sql
SHOW TABLES;
```

8. Create the table `batches` with a primary key `id` and a `name` column

```sql
CREATE TABLE batches (
  id INT PRIMARY KEY,
  name VARCHAR(255)
);
```

9. Show the schema of the table `batches`

```sql
DESCRIBE batches;
```

10. Create the table `students` with a primary key `id`, a `name` column, a `batch_id` column as a foreign key to the `batches` table
```sql
CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  batch_id INT,
  FOREIGN KEY (batch_id) REFERENCES batches(id)
);
```

11. Delete the table `students`

```sql
DROP TABLE students;
```
