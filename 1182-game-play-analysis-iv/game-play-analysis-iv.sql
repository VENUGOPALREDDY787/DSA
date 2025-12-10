# Write your MySQL query statement below
SELECT ROUND(
    COUNT(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
    2
) fraction
FROM Activity a
JOIN (
    SELECT player_id, MIN(event_date) d 
    FROM Activity GROUP BY player_id
) x 
ON a.player_id = x.player_id 
AND a.event_date = x.d + INTERVAL 1 DAY;