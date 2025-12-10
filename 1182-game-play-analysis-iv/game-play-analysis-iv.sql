# Write your MySQL query statement below
with sales as (select player_id, event_date, 
first_value(event_date) over(partition by player_id ORDER BY event_date)  as pre_day
 from Activity)

select round(count(case when DATEDIFF(event_date, pre_day) = 1 then player_id  end)/count(distinct(player_id)),2) as fraction  
from sales 