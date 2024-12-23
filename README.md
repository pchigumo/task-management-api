# Task Management API

## Overview
The **Task Management API** allows users to manage their tasks with features such as task creation, updating, deletion, and retrieval. The application uses JWT for authentication, H2 in-memory database for persistence, and Spring Boot as the backend framework.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven

### Running the Application
To start the application, run the following command:
```bash
mvn clean package spring-boot:run
```

The application will run on port `8081` by default.

### Accessing the H2 Database
The application uses an H2 in-memory database. You can access the H2 console by navigating to:
```
http://localhost:8081/h2-console
```

Use the following credentials to log in:
- **JDBC URL:** `jdbc:h2:mem:taskdb`
- **Username:** `admin`
- **Password:** `admin`

## Configuration
The application is configured with the following properties:

```properties
spring.application.name=Task Management API

spring.datasource.url=jdbc:h2:mem:taskdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=admin

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.globally_quoted_identifiers=true

spring.h2.console.path=/h2-console

server.port=8081

jwt.secret=ABCDEFGHIJKLMNOPQRSabcdefghijkstuvwxyz3456789
jwt.validity=300000
```

## API Endpoints

### Authentication
#### Sign Up
- **URL:** `POST /api/auth/signup`
- **Request Body:**
  ```json
  {
      "username": "pauline",
      "email": "pau@icloud.com",
      "password": "abc123"
  }
  ```

#### Login
- **URL:** `POST /api/auth/login`
- **Request Body:**
  ```json
  {
      "username": "pauline",
      "password": "abc123"
  }
  ```
- **Response:** A JWT token to be used for subsequent requests.

### Tasks
#### Create Task
- **URL:** `POST /api/tasks`
- **Headers:**
  ```
  Authorization: Bearer <JWT_TOKEN>
  ```
- **Request Body:**
  ```json
  {
      "title": "My title",
      "description": "The Description",
      "status": "In progress",
      "dueDate": "2024-12-31"
  }
  ```

#### List Tasks
- **URL:** `GET /api/tasks`
- **Headers:**
  ```
  Authorization: Bearer <JWT_TOKEN>
  ```

#### Update Task
- **URL:** `PUT /api/tasks/{id}`
- **Headers:**
  ```
  Authorization: Bearer <JWT_TOKEN>
  ```
- **Request Body:**
  ```json
  {
      "title": "Updated title",
      "description": "Updated description",
      "status": "Completed",
      "dueDate": "2024-12-31"
  }
  ```

#### Delete Task
- **URL:** `DELETE /api/tasks/{id}`
- **Headers:**
  ```
  Authorization: Bearer <JWT_TOKEN>
  ```

## Security
- The application uses JWT for authentication.
- Add the token to the `Authorization` header in the format `Bearer <JWT_TOKEN>` for protected endpoints.

## Notes
- Ensure you sign up and log in to obtain a token before accessing the `/tasks` endpoint.
- The H2 database is in-memory and will reset upon application restart.

## Authors
- Pauline Chigumo
