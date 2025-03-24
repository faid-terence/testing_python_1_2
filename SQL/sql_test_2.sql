CREATE TABLE books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    isbn TEXT NOT NULL UNIQUE,
    genre TEXT,
    publication_year INTEGER,
    price DECIMAL(10,2),
    stock_quantity INTEGER
);

INSERT INTO books (title, author, isbn, genre, publication_year, price, stock_quantity)
VALUES (
    'The Hitchhiker''s Guide to the Galaxy',
    'Douglas Adams',
    '9780345391803',
    'Science Fiction',
    1979,
    12.99,
    5
);