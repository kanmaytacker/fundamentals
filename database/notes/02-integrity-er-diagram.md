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
### Entity Integrity
### Referential integrity
### Domain integrity
### User-defined integrity
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

---
## ER Diagrams
---
## References
## Reading List

