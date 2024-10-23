# Spring Security JWT Authentication

![Spring Security JWT](https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?logo=spring&logoColor=white)

A robust Spring Boot application implementing JWT (JSON Web Token) authentication to secure API endpoints. This project demonstrates how to integrate JWT with Spring Security, manage user registration and login, and protect sensitive routes using token-based authentication.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configure-applicationproperties)
- [Project Structure](#project-structure)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
  - [User Registration](#user-registration)
  - [User Login](#user-login)
  - [Accessing Protected Routes](#accessing-protected-routes)
- [Testing with Postman](#testing-with-postman)
- [Exception Handling](#exception-handling)
- [Reference](#reference)
- [License](#license)

## Features

- **JWT Authentication**: Secure API endpoints using JSON Web Tokens.
- **User Registration & Login**: Endpoints to register new users and authenticate existing ones.
- **Protected Routes**: Restrict access to certain API endpoints based on authentication.
- **Custom Exception Handling**: Provide meaningful error messages for various authentication and validation errors.
- **Integration with MySQL**: Persist user data in a MySQL database.
- **Lombok Integration**: Reduce boilerplate code with Lombok annotations.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java 23**: Ensure Java is installed on your machine. [Download Java](https://www.oracle.com/java/technologies/javase/jdk23-downloads.html)
- **Maven**: Project management and comprehension tool. [Install Maven](https://maven.apache.org/install.html)
- **MySQL**: Relational database management system. [Download MySQL](https://dev.mysql.com/downloads/mysql/)
- **Postman**: API testing tool. [Download Postman](https://www.postman.com/downloads/)
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE with Lombok support.

## Installation

Follow these steps to set up and run the project locally.

### 1. Create a New Spring Boot Project

Use [Spring Initializr](https://start.spring.io/) to create a new Spring Boot project with the following configurations:

- **Project**: Maven
- **Language**: Java
- **Packaging**: Jar
- **Java Version**: 23
- **Dependencies**:
  - Spring Web
  - Spring Security
  - Spring Data JPA
  - MySQL Driver
  - Lombok
  - JWT (e.g., `jjwt`)

### 2. Clone the Repository

If you have a repository set up, clone it. Otherwise, initialize a new Git repository.

```bash
git clone https://github.com/yourusername/springsecurityjwt.git
cd springsecurityjwt
```
### 3. Configure application.properties
Add the following configuration settings in src/main/resources/application.properties:

```bash
# Server Configuration
server.port=8005

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=your_jwt_secret_key
jwt.expiration=3600000
```

### 4. Create MySQL Database
Open your MySQL client (e.g., MySQL Workbench) and execute the following command to create the taskdb database:

```bash
CREATE DATABASE taskdb;
```

### 5. Add JWT Dependencies in pom.xml
### 6. Reload Maven Project
In your IntelliJ IDEA:

- Right-click on the project.
- Navigate to Maven > Reload Project.

```bash
mkdir -p src/main/java/com/yourusername/project/{entity,repository,config,service,controller,dto,exception}
```

### 8. Implement Core Components
Add the following classes to their respective packages:

#### Configuration Classes
- ApplicationConfiguration
- JwtAuthenticationFilter
- SecurityConfiguration

#### Controllers

- AuthenticationController
- UserController

#### DTOs

- LoginResponse
- LoginUserDto
- RegisterUserDto
- UserResponseDto

#### Entities

- User

#### Services

- AuthenticationService
- UserService

#### Repositories

- UserRepository

#### Handling

- GlobalExceptionHandler

### 9. Running the Application
Using Postman, run the application with the following values:

```bash

url : http://localhost:8005/auth/signup
method: POST
Body - raw - JSON
Sample values:
{
  "fullName": "tom",
  "email": "tom@mail.com",
  "password": "test"
}
```