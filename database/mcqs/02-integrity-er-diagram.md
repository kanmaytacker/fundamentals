# Questions
1. Joe Bloggs is helping us build Scaler. He is trying to delete some batches but the database throws an error that the batch is used by a tuple in another table. Which type of integrity constraint is being enforced here?
    >A. User-defined integrity \
    B. Domain integrity \
    C. Entity integrity \
    D. Referential integrity
---
2. Which of the following is not an example of domain integrity constraints?

    >A. Validating that input is correct data type \
    B. Ensuring value is not null if a non-nullable column \
    C. Making sure each row is unique \
    D. Checking if the value exceeds maximum length
---
3. Joe Bloggs is taking some time off to build his house. A house can have many rooms. What is the cardinality of house to room?
    >A. One to Many (1:m) \
    B. One to One (1:1) \
    C. Many to Many (m:n)
---
4. Let us say a house has a house_id and a room has room_id.
Given the cardinality of house to room, which is the ideal place to store their relationship i.e. reference?
    >A. room_id in house \
    B. Separate table for room_id and house_id \
    C. Array of room_ids in house \
    D. house_id in room

---
# Answers
1. D. `Referential integrity`
2. C `Making sure each row is unique`
3. A `One to Many (1:m)`
4. D `house_id in room`