# SQL Joins and Aggregation

## Agenda
* SQL Joins
* Aggregation Functions (SUM, AVG, COUNT etc)
* Sub-queries
* Built-in Functions


## Joins

Join is the widely-used clause in the SQL Server essentially to combine and retrieve data from two or more tables. In a real-world relational database, data is structured in many tables and which is why, there is a constant need to join these multiple tables based on logical relationships between them.

### Inner join

Inner Join clause in SQL Server creates a new table (not physical) by combining rows that have matching values in two or more tables. This join is based on a logical relationship (or a common field) between the tables and is used to retrieve data that appears in both tables.

![Inner Join](https://i.stack.imgur.com/kZcvR.gif)

Assume, we have two tables, Table A and Table B, that we would like to join using SQL Inner Join. The result of this join will be a new result set that returns matching rows in both these tables. The intersection part in black below shows the data retrieved using Inner Join.

![Inner Join](https://www.sqlshack.com/wp-content/uploads/2019/06/venn-diagram-representation-of-sql-inner-join-.png)

**Keyword**: `INNER JOIN` or simply `JOIN`
**Syntax**: `SELECT column1, column2, ... FROM table_name1 JOIN table_name2 ON condition`

For example, we want to get the batch names of all the students along with their names.
| id  | first_name | last_name | batch_name |
| --- | ---------- | --------- | ---------- |
| 1   | John       | Watson    | Sherlock   |
| 2   | Mycroft    | Holmes    | Sherlock   |

This can be achieved by using the following SQL query:

```sql
SELECT s.first_name, s.last_name, b.batch_name FROM students s JOIN batches b ON s.batch_id = b.id;
```

### Left Outer Join

Let us consider the students and batches tables below:

| id  | first_name | last_name | batch_id |
| --- | ---------- | --------- | -------- |
| 1   | John       | Watson    | 1        |
| 2   | Mycroft    | Holmes    | 1        |
| 3   | Moriarty   | Patel     | NULL     |

| id  | batch_name       |
| --- | ---------------- |
| 1   | Sherlock Academy |
| 2   | Crime Academy    |

Now if we decide to get the batch names of all the students along with their names with an `inner join` we will get the following result:

| id  | first_name | last_name | batch_name       |
| --- | ---------- | --------- | ---------------- |
| 1   | John       | Watson    | Sherlock Academy |
| 2   | Mycroft    | Holmes    | Sherlock Academy |

Since both John and Mycroft had a valid batch_id, the respective rows were merged to produce the result.
But Moriarty did not have a valid batch_id, so the result set will not contain him.

But if we want to run a query to get all students along with their batch names or NULL if they do not have a batch_id, we can use the **Left Outer Join**.
> The LEFT JOIN keyword returns all records from the left table (table1), and the matching records from the right table (table2). The result is 0 records from the right side, if there is no match.

![Left Outer Join](https://www.w3schools.com/sql/img_leftjoin.gif)

**Keyword**: `LEFT OUTER JOIN` or simply `LEFT JOIN`
**Syntax**: `SELECT column1, column2, ... FROM table_name1 LEFT JOIN table_name2 ON condition`

The query for fetching students with their batch names now will be:

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        LEFT JOIN
    batches b ON s.batch_id = b.id;
```

And the result will be:

| id  | first_name | last_name | batch_name       |
| --- | ---------- | --------- | ---------------- |
| 1   | John       | Watson    | Sherlock Academy |
| 2   | Mycroft    | Holmes    | Sherlock Academy |
| 3   | Moriarty   | Patel     | NULL             |

### Right Outer Join

Similarly, `RIGHT OUTER JOIN` returns all records from the right table (table2), and the matching records from the left table (table1). The result is 0 records from the left side, if there is no match.

Now if we want to get all the batches along with their students if present else `NULL`, we can use `RIGHT OUTER JOIN`.

**Keyword**: `RIGHT OUTER JOIN` or simply `RIGHT JOIN`
**Syntax**: `SELECT column1, column2, ... FROM table_name1 RIGHT JOIN table_name2 ON condition`

![Right Join](https://www.w3schools.com/sql/img_rightjoin.gif)

The query for fetching batches with their students now will be:

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        RIGHT JOIN
    batches b ON s.batch_id = b.id;
```

This will return the following result:

| id   | first_name | last_name | batch_name       |
| ---- | ---------- | --------- | ---------------- |
| 1    | John       | Watson    | Sherlock Academy |
| 2    | Mycroft    | Holmes    | Sherlock Academy |
| NULL | NULL       | NULL      | Crime Academy    |

### Full Outer Join

The FULL OUTER JOIN clause returns a result set that includes rows from both left and right tables.

When no matching rows exist for the row in the left table, the columns of the right table will contain NULL. Likewise, when no matching rows exist for the row in the right table, the column of the left table will contain NULL.

![Full Outer Join](https://www.w3schools.com/sql/img_fulljoin.gif)

**Keyword**: `FULL OUTER JOIN` or simply `FULL JOIN`
**Syntax**: `SELECT column1, column2, ... FROM table_name1 FULL JOIN table_name2 ON condition`

The query for fetching batches with their students now will be:

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        FULL JOIN
    batches b ON s.batch_id = b.id;
```

This will return the following result:
| id   | first_name | last_name | batch_name       |
| ---- | ---------- | --------- | ---------------- |
| 1    | John       | Watson    | Sherlock Academy |
| 2    | Mycroft    | Holmes    | Sherlock Academy |
| 3    | Moriarty   | Patel     | NULL             |
| NULL | NULL       | NULL      | Crime Academy    |

> **Warning**
> MySQL does not support the FULL OUTER JOIN clause.

### Cross Join

The result set from a `cross join` will include all rows from both tables, where each row is the combination of the row in the first table with the row in the second table. In general, if each table has `n` and `m` rows respectively, the result set will have `n` x `m` rows.

In other words, the CROSS JOIN clause returns a Cartesian product of rows from the joined tables.

**Keyword**: `CROSS JOIN`
**Syntax**: `SELECT column1, column2, ... FROM table_name1 CROSS JOIN table_name2`
**Syntax 2**: `SELECT column1, column2, ... FROM table_name1, table_name2`

An example query for fetching from the students and batches tables will be:

```sql
SELECT 
    s.first_name, s.last_name, b.name
FROM
    students s
        CROSS JOIN
    batches b;
```

Note that different from the INNER JOIN, LEFT JOIN , and RIGHT JOIN clauses, the CROSS JOIN clause does not have a join predicate. In other words, it does not have the ON or USING clause.

If you add a WHERE clause, in case table t1 and t2 has a relationship, the CROSS JOIN works like the INNER JOIN.

---

## Aggregate Functions

> MySQL's aggregate function is used to perform calculations on multiple values and return the result in a single value like the average of all values, the sum of all values, and maximum & minimum value among certain groups of values.

> We mainly use the aggregate functions in databases, spreadsheets and many other data manipulation software packages. In the context of business, different organization levels need different information such as top levels managers interested in knowing whole figures and not the individual details. These functions produce the summarised data from our database. Thus, they are extensively used in economics and finance to represent the economic health or stock and sector performance.

The ISO SQL standard defines the following aggregate functions:

| Function | Description                                   |
| -------- | --------------------------------------------- |
| MIN      | Return the minimum value                      |
| MAX      | Return the maximum value                      |
| SUM      | Return the sum of all values                  |
| AVG      | Return the average value of the argument      |
| COUNT    | Return a count of the number of rows returned |


### Get the minimum value

**Keyword**: `MIN`
**Syntax**: `SELECT MIN(column_name) FROM table_name`

Getting the minimum value without using the aggregate function could be done by using the `ORDER BY` clause.

```sql
SELECT 
    first_name, iq
FROM
    students
ORDER BY iq
LIMIT 1;
```

This would give the correct answer but not in the case of NULL values. By default, MySQL will return the NULL value at the top of the sorted rows. Special handling will have to be done to get the correct result.

This is why we can use the aggregate function `MIN` to get the minimum value.

```sql
SELECT 
    MIN(iq)
FROM
    students;
```

**The aggregate functions ignore the NULL values.**

### Get the maximum value

**Keyword**: `MAX`
**Syntax**: `SELECT MAX(column_name) FROM table_name`

To get the maximum IQ in students, we can use the aggregate function `MAX`.

```sql
SELECT 
    MAX(iq)
FROM
    students;
```

### Get the sum of all values

**Keyword**: `SUM`
**Syntax**: `SELECT SUM(column_name) FROM table_name`

To get the sum of all the IQ in students, we can use the aggregate function `SUM`.

```sql
SELECT 
    SUM(iq)
FROM
    students;
```

### Get the average value

**Keyword**: `AVG`
**Syntax**: `SELECT AVG(column_name) FROM table_name`

To get the average IQ in students, we can use the aggregate function `AVG`.

```sql
SELECT 
    AVG(iq)
FROM
    students;
```

### Get the number of rows

**Keyword**: `COUNT`
**Syntax**: `SELECT COUNT(column_name) FROM table_name`

To get the number of rows in students, we can use the aggregate function `COUNT`.

```sql
SELECT 
    COUNT(*)
FROM
    students;
```

Using `*` instead of a column name will return the number of rows in the table whereas using a column name will return the number of rows that have a non-null value in a column.

## GROUP BY clause

The GROUP BY clause groups a set of rows into a set of summary rows by values of columns or expressions. The GROUP BY clause returns one row for each group. In other words, it reduces the number of rows in the result set

**Keyword**: `GROUP BY`
**Syntax**: `SELECT column1, column2, ... FROM table_name GROUP BY column1, column2, ...`

In this syntax, you place the GROUP BY clause after the FROM and WHERE clauses. After the GROUP BY keywords, you place is a list of comma-separated columns or expressions to group rows.

> MySQL evaluates the GROUP BY clause after the FROM and WHERE clauses and before the HAVING, SELECT, DISTINCT, ORDER BY and LIMIT clauses

![Group By](https://www.mysqltutorial.org/wp-content/uploads/2021/07/MySQL-Group-By.svg)

Fields that are not encapsulated within an aggregate function and must be included in the GROUP BY Clause at the end of the SQL statement.

For example, the following query will return the number of students in each batch:

```sql
SELECT 
    batch_id, AVG(iq)
FROM
    students
GROUP BY batch_id;
```

You can also use the `HAVING` clause to filter the result set.
For example, the following query will return the number of students in each batch where each batches average IQ is greater than or equal to 100:
```sql
SELECT 
    batch_id, AVG(iq)
FROM
    students
GROUP BY batch_id
HAVING AVG(iq) >= 100;
```


## Problems
1. [Simple - I](https://leetcode.com/problems/big-countries/)
2. [Simple - II](https://leetcode.com/problems/find-customer-referee/)
3. [Joins - I](https://leetcode.com/problems/employees-earning-more-than-their-managers/)
4. [Joins - II](https://leetcode.com/problems/combine-two-tables/)
5. [Join - III](https://leetcode.com/problems/delete-duplicate-emails/)
6. [Aggregation - I](https://leetcode.com/problems/duplicate-emails/)
7. [Aggregation - II](https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/)
8.  [Aggregation - III](https://leetcode.com/problems/classes-more-than-5-students/)
