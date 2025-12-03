# Write your MySQL query statement below
SELECT user_id, name, mail
FROM users
WHERE REGEXP_like(mail, '^[A-Za-z][A-Za-z0-9._-]*@leetcode\\.com$','c');