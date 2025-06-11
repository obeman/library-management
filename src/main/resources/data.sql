-- Insert sample authors
INSERT INTO author (name) VALUES
    ('J.K. Rowling'),
    ('George R.R. Martin'),
    ('Stephen King');

-- Insert sample books
INSERT INTO book (title, category, publishing_year, author_id) VALUES
    ('Harry Potter and the Philosopher''s Stone', 'Fantasy', 1997, 1),
    ('A Game of Thrones', 'Fantasy', 1996, 2),
    ('The Shining', 'Horror', 1977, 3);

-- Insert sample members
INSERT INTO member (name, email, phone) VALUES
    ('John Doe', 'john.doe@email.com', '123-456-7890'),
    ('Jane Smith', 'jane.smith@email.com', '098-765-4321');

-- Insert sample borrowed books
INSERT INTO borrowed_book (book_id, member_id, borrow_date, return_date) VALUES
    (1, 1, '2024-01-01', NULL),
    (2, 2, '2024-01-15', NULL);