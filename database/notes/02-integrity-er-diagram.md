# Data Integrity and ER Diagrams

![ERD](https://www.memecreator.org/static/images/memes/5074790.jpg)

## Agenda
* Data Integrity
* ER Diagrams
* Functional Dependencies
* Normalization

## Key Terms
### Schema
> refers to the organization of data as a blueprint of how the database is constructed

> In a relational database, the schema defines the tables, fields, relationships, views, indexes, packages, procedures, functions, queues, triggers, types, sequences, materialized views, synonyms, database links, directories, XML schemas, and other elements

### Data Integrity
> is the overall accuracy, completeness, and consistency of data
> the maintenance of, and the assurance of, data accuracy and consistency over its entire life-cycle
### ER Diagrams

## Schema
A schema is a blueprint of a database. It is created before you actually construct the database so that the schema design can be reviewed. Schema diagrams are also a great way to document the database structure in one place.

Remember our student's database from the [previous lesson](01-database-fundamentals.md)? We had the three following tables
* `students` (id, name, age, address, phone, email, batch ID)
* `mentors` (id, name, age, address, phone, email)
* `batches` (id, name, mentor, start date, type, mentor ID)

So each table has `ID` as primary key. The `students` table has a `batch ID` field that references the `batches` table and the `batches` table has a `mentor ID` field that references the `mentors` table. These are examples of foreign keys. These are some the items that are present in a schema. A schema will also contain indexes, constraints, and other items that are present in a table.

Following is a schema diagram for the above database. Note that the primary key is not highlighted here, which ideally should be.

![Schema](../media/schema.png)

> **Note**
>
> Try it yourself. \
> Go to [this](https://diagramplus.com/) website and import [this](../media/schema.diagram) diagram. \
> Try adding a new column or even a new table.

---
## Data Integrity
Remember when we stored our data in [files](01-database-fundamentals.md#brute-force---files)? That was the simplest way to store data, but it had a lot of issues. One of the major issues was that we can never be sure that our data is consistent with the way we want it to be.

Some issues that we can encounter are
* Duplicate rows - multiple rows with the same data
* A string in a field where a number is expected, or vice versa.
* Updating or deleting a mentor that has batches assigned to it
* Entering 20 digits as a phone number instead of a 10-digit phone number

This is where DBMS excels. Data integrity is normally enforced in a database system by a series of integrity constraints or rules.
Data integrity (or actually logical integrity) can be divided into four main categories:
### Entity integrity
Each row to be unique within its table. No two rows can be the same. To achieve this, a **primary key** can be defined.

The primary key field contains a unique identifier – no two rows can contain the same unique identifier.

> Every table must have a primary key and that the column or columns chosen to be the primary key should be unique and not null

### Referential integrity
> Referential integrity is a property of data stating that all its references are valid.


When a foreign key value is used it must reference a valid, existing primary key in the parent table.
For referential integrity to hold in a relational database, any column in a base table that is declared a foreign key can only contain either **null values or values from a parent table's primary key or a candidate key**.

>  For instance, deleting a record that contains a value referred to by a foreign key in another table would break referential integrity.

### Domain integrity
Domain integrity concerns the validity of entries for a given column. Selecting the appropriate data type for a column is the first step in maintaining domain integrity. Other steps could include, setting up appropriate constraints and rules to define the data format and/or restricting the range of possible values.

### User-defined integrity

User-defined integrity allows the user to apply business rules to the database that aren’t covered by any of the other three data integrity types.

---


## ER Diagrams
---
## References
## Reading List

