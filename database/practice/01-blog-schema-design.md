# Schema Design - Blog Management System

## Introduction

![Blog Management System](https://contenthub-static.grammarly.com/blog/wp-content/uploads/2017/11/how-to-write-a-blog-post.jpeg)
A blog is a website where people can post their thoughts and opinions. It is a great way to share information with the world. In this practice, we will design a database schema for a blog management system. The schema will be used to store information about users, posts, and comments.

## Requirements

1. The blog system will have multiple users.
2. Each user has a first name, a last name, a mobile number, an email address. 
3. For each user, we will store the date and time when the user last logged in.
4. Users can create multiple posts.
5. Each post has a title, a body, and a date and time when the post was published.
6. A user can also publish the post or keep it as a draft.
7. A post can also refer to a parent post. This is useful when a user wants to create a series of posts.
8. A post can have multiple tags.
9. Each tag should have a name and a description. We should also store who added the tag to the post and the time.
10. A user can comment on a post. 

## Entities

Identify the entities in the above requirements. For each entity, identify the attributes.

```
1. Entity name: `ENTITY_NAME`
    - Attribute 1
    - Attribute 2
...
```

## Tables

List all of the tables that you will need to create for the above requirements. For each table, list the columns and their data types.

```
1. Table name: `TABLE_NAME`
    - Column 1: `DATA_TYPE`
    - Column 2: `DATA_TYPE`
...
```

## Relationships

Identify the relationships between the entities. For each relationship, identify the cardinality.

```
1. Relationship name: `RELATIONSHIP_NAME`
    - Entity 1: `ENTITY_NAME`
    - Entity 2: `ENTITY_NAME`
    - Cardinality: `CARDINALITY`
...
```

## Schema diagram

Draw a schema diagram for the above requirements.

```
```

## New requirements

1. A user can like a post.
2. A user can also like a comment.
3. The system should also store the date and time when the user liked the post or comment.

Modify the above schema to add the above requirements.

```
```