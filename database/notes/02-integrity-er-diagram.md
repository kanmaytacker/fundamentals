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
Data integrity (or actually logical integrity) can be divided into three main categories:

### Entity integrity
Each row to be unique within its table. No two rows can be the same. To achieve this, a **primary key** can be defined.

The primary key field contains a unique identifier – no two rows can contain the same unique identifier.

> Every table must have a primary key and that the column or columns chosen to be the primary key should be unique and not null

Let us try it out on our database. Following is the `students` table.

```sql
SELECT
    *
FROM
    students;
```
![Students](../media/students-table.png)

Let us now try to insert a duplicate row in our database. Since our PK is `id`, we will have to manually add a duplicate value. 

```sql
INSERT INTO STUDENTS (id,name,age,phone,email,address,batch_id)
    VALUES (3,"John Watson",30,123456789,"i.am@sherlock.ed","221B Baker Street", 3);
```
![Duplicate error](../media/duplicate-error.png)
As you can see, the database does not allow us to insert a duplicate row.

![Gandalf](https://i.kym-cdn.com/entries/icons/original/000/002/144/You_Shall_Not_Pass!_0-1_screenshot.jpg)

### Referential integrity
> Referential integrity is a property of data stating that all its references are valid.

When a foreign key value is used it must reference a valid, existing primary key in the parent table.
For referential integrity to hold in a relational database, any column in a base table that is declared a foreign key can only contain either **null values or values from a parent table's primary key or a candidate key**.

>  For instance, deleting a record that contains a value referred to by a foreign key in another table would break referential integrity.

> The referential integrity rule states that any foreign-key value can only be in one of two states. The usual state of affairs is that the foreign-key value refers to a primary key value of some table in the database. The other being NULL which means no relationship exists.

Let us try it on our students table again. The table is the same as above.
![Students](../media/students-table.png)

We'll now try to enter a tuple which has a batch ID that does not exist in the batches table.
```sql
INSERT INTO STUDENTS (id,name,age,phone,email,address,batch_id)
    VALUES (4,"Zuck",30,123456789,"zuck@givemedata.com","someverse", 4);
```
![FK error](../media/fk-error.png)
> **Note**
> Additionally, MySQL requires that the referenced columns be indexed for performance reasons. However, the system does not enforce a requirement that the referenced columns be UNIQUE or be declared NOT NULL.

### Domain integrity
> all columns in a relational database must be declared upon a defined domain

Domain integrity concerns the validity of entries for a given column. For instance, if a column is declared to be of type `INTEGER`, then only integers can be entered.

Another example is if a column has a `NOT NULL` constraint, then it cannot be null.

> Each attribute in the model should be assigned domain information which includes:
> * **Data Type** - Basic data types are integer, decimal, or character. Most data bases support variants of these plus special data types for date and time.
> * **Length** - This is the number of digits or characters in the value. For example, a value of 5 digits or 40 characters.
> * **Date Format** - The format for date values such as dd/mm/yy or mm/dd/yyyy or yy/mm/dd.
> * **Range** - The range specifies the lower and upper boundaries of the values the attribute may legally have.
> * **Constraints** - Are special restrictions on allowable values. For example, the LeavingDate for an Employee must always be greater than the HireDate for that Employee.
> * **Null support** - Indicates whether the attribute can have null values.
> * **Default value** (if any) - The value an attribute instance will have if a value is not entered.

Let us try to enter a tuple with a `phone` field that is not an integer but a string. Following is our students table and the result of the query.
```sql
INSERT INTO STUDENTS (id,name,age,phone,email,address,batch_id)
    VALUES (4,"Zuck",30,123456789,"zuck@givemedata.com","someverse",NULL);
```
![Type Error](../media/type-error.png)

---

## ER Diagrams
---
## References
* [Data Integrity](https://en.wikipedia.org/wiki/Data_integrity)
* [What is data integrity?](https://database.guide/what-is-data-integrity/)
## Reading List

