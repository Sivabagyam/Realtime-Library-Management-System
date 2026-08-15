# Library Management System

A full-stack Library Management System developed using Java, Spring Boot, MySQL, and React. The application provides functionality for managing books, members, reservations, returns, and user profiles.

## Features

### Member Management
- Member registration and verification
- Member login
- View member information
- Profile management

### Book Management
- Add and manage books
- Check book availability
- Search for books
- View book details
- Paginated book listing

### Reservation and Return
- Reserve available books
- Track reserved books
- Return books
- Update book availability

### Frontend
- Responsive React user interface
- Component-based architecture
- React Router navigation
- REST API integration
- Reusable components
- Search and pagination

## Technologies Used

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs
- Maven

### Frontend
- React.js
- JavaScript
- HTML5
- CSS3
- Bootstrap

### Database
- MySQL

### Tools
- Git
- GitHub
- Postman
- VS Code
- Spring Tool Suite

## Architecture

React Frontend
       |
       v
REST APIs
       |
       v
Spring Boot
       |
       v
Spring Data JPA / Hibernate
       |
       v
MySQL

## API Integration

The React frontend communicates with the Spring Boot backend through REST APIs.

Example endpoints:

GET /library/getpagebooks?page=0&size=12

GET /library/getbooks/{id}

## Database

MySQL is used for persistent data storage. Spring Data JPA and Hibernate are used for database operations and object-relational mapping.

## Key Concepts Practiced

- REST API development
- Spring Boot application architecture
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- MySQL database integration
- Pagination
- React components
- React Hooks
- React Router
- Frontend-backend integration
- Git version control

## Future Improvements

- JWT-based authentication
- Role-based authorization
- Admin dashboard
- Advanced book filtering
- Email notifications
- Docker deployment
- Cloud deployment

## Author

Sivabagyam

GitHub: https://github.com/Sivabagyam
