CREATE TABLE customers (
    id INTEGER PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    company TEXT,
    email TEXT,
    country TEXT,
    subscription_start DATE
);

SELECT company
FROM customers
WHERE country = 'Latvia' 
AND first_name LIKE 'X%'
AND subscription_start < date('now');