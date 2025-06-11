-- Drop tables if they exist (in correct order due to foreign key constraints)
DROP TABLE IF EXISTS borrowed_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS member;

-- Create author table
CREATE TABLE author (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create member table
CREATE TABLE member (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) NOT NULL
);

-- Create book table
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    publishing_year INTEGER NOT NULL,
    author_id BIGINT NOT NULL,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) 
        REFERENCES author(id) ON DELETE CASCADE
);

-- Create borrowed_book table
CREATE TABLE borrowed_book (
    id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    member_id BIGINT NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE,
    CONSTRAINT fk_borrowed_book_book FOREIGN KEY (book_id) 
        REFERENCES book(id) ON DELETE CASCADE,
    CONSTRAINT fk_borrowed_book_member FOREIGN KEY (member_id) 
        REFERENCES member(id) ON DELETE CASCADE
); 