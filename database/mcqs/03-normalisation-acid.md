# Questions
1. Joe Bloggs is creating a social media today. However, Joe has kept user and group information in the same table. Now whenever Joe removes a user, the group information is also gone. Which type of anomaly is this?
    >A. Insertion \
    B. Updation \
    C. Deletion
---
2. A user has an ID, name, email and group ID. One user can only have one email and it is unique.
Which of the following dependencies is not correct?

    >A. ID -> NAME \
    B. EMAIL -> NAME \
    C. EMAIL -> GROUP ID \
    D. NAME -> GROUP ID
---
3. Joe has created a table for group members where the columns are `Group ID, User ID, Rating, Group Name`. The primary key here is `Group ID, User ID`.
Which type of functional dependency exists?
    >A. No functional dependency \
    B. Transitive \
    C. Partial
---
4. Joe has identified that one of his tables does not satisfy 1NF constraints. Which of the following types of ERD attributes are allowed under 1NF?
    >A. Composite \
    B. Multivalued \
    C. Derived \
    D. Index

---
# Answers
1. A. `Deletion`
2. D `NAME -> GROUP ID`
3. C `Partial`
4. C `Derived`