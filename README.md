# Library Management System

A Spring Boot application for managing a library system with features for handling books, authors, members, and book borrowing.

## Features

- Book Management (CRUD operations)
- Author Management
- Member Management
- Book Borrowing System
- RESTful API endpoints
- PostgreSQL Database
- Input validation and error handling

## Tech Stack

- Java 21
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## API Endpoints

### Authors
- `POST /api/authors` - Create a new author
- `GET /api/authors` - Get all authors
- `GET /api/authors/{id}` - Get author by ID
- `PUT /api/authors/{id}` - Update author
- `DELETE /api/authors/{id}` - Delete author

### Books
- `POST /api/books` - Create a new book
- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get book by ID
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book

### Members
- `POST /api/members` - Create a new member
- `GET /api/members` - Get all members
- `GET /api/members/{id}` - Get member by ID
- `PUT /api/members/{id}` - Update member
- `DELETE /api/members/{id}` - Delete member

### Borrowed Books
- `POST /api/borrowed-books` - Create a new borrowed book record
- `GET /api/borrowed-books` - Get all borrowed books
- `GET /api/borrowed-books/{id}` - Get borrowed book by ID
- `PUT /api/borrowed-books/{id}` - Update borrowed book
- `DELETE /api/borrowed-books/{id}` - Delete borrowed book

## Setup

1. Clone the repository
2. Configure PostgreSQL database
3. Update `application.properties` with your database credentials
4. Run the application using `mvn spring-boot:run`

## Database Schema

The application uses PostgreSQL with the following main tables:
- author
- book
- member
- borrowed_book

## API Documentation

A Postman collection is included in the repository (`LibraryAPI.postman_collection.json`) for testing the API endpoints. 