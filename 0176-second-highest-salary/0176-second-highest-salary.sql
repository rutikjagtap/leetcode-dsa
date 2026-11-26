# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary 
from Employee
where salary <
(SELECT MAX(salary)
from Employee)
;