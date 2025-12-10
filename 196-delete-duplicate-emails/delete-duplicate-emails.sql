# Write your MySQL query statement below
WITH DuplicateEmails AS (
    SELECT 
        id,
        ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
    FROM 
        Person
)
DELETE FROM Person
WHERE id IN (
    SELECT id FROM DuplicateEmails WHERE rn > 1
);