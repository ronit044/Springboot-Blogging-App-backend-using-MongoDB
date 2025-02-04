# Blogging Application Backend (Under Progress)

## Overview
The **Blogging Application Backend** is a Spring Boot-based REST API that provides essential functionalities for a blogging platform. It is built using **Spring Boot** and **MongoDB** for efficient data storage and retrieval. The project follows a structured **MVC architecture** with well-defined services and repository layers.

## Tech Stack
- **Java 17+**
- **Spring Boot** (Spring Web, Spring Data MongoDB, Spring Security)
- **MongoDB** (NoSQL Database)
- **Maven** (Dependency Management & Build Tool)
- **JWT Authentication**

## Project Structure
```
ronit044-springboot-blogging-app-backend-using-mongodb/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bloggingApp/
│   │   │           └── bloggingApplication/
│   │   │               ├── BloggingApplication.java        # Main Application Entry Point
│   │   │               ├── configuration/                 # Security & Configurations
│   │   │               │   ├── SpringSecurity.java        # Spring Security Configuration
│   │   │               │   └── transactionalConfig.java   # Transaction Management
│   │   │               ├── controllers/                   # API Controllers
│   │   │               │   ├── BlogUserController.java    # Blog-User API Endpoints
│   │   │               │   └── UserController.java        # User API Endpoints
│   │   │               ├── entities/                      # Database Entities
│   │   │               │   ├── Blog.java                  # Blog Entity
│   │   │               │   └── User.java                  # User Entity
│   │   │               ├── repositories/                  # Data Access Layer
│   │   │               │   ├── BlogRepo.java              # Blog Repository
│   │   │               │   └── UserRepo.java              # User Repository
│   │   │               └── services/                      # Business Logic Layer
│   │   │                   ├── BlogServices.java         # Blog Service
│   │   │                   ├── BlogUserServices.java     # Blog-User Service
│   │   │                   └── UserServices.java        # User Service
│   │   └── resources/
│   │       └── application.properties                    # Application Configuration
└── .mvn/
    └── wrapper/
        └── maven-wrapper.properties                       # Maven Wrapper
```

## Features
- **User Authentication**
  - User Registration & Login
  - JWT-based Authentication
  
- **Blog Management**
  - Create, Read, Update, Delete (CRUD) Blogs
  - Fetch Blogs by User

- **Security**
  - Password Encryption
  - Secure Endpoints with JWT

## Installation & Setup
### Prerequisites
- **Java 17+** installed
- **MongoDB** running locally or remotely
- **Maven** installed

### Clone the Repository
```sh
git clone https://github.com/ronit044/ronit044-springboot-blogging-app-backend-using-mongodb.git
cd ronit044-springboot-blogging-app-backend-using-mongodb
```

### Configure Application Properties
Update `src/main/resources/application.properties` with your MongoDB connection details:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/bloggingApp
spring.security.jwt.secret=your_secret_key
```

### Build & Run the Application
#### Using Maven
```sh
mvn clean install
mvn spring-boot:run
```
#### Using Maven Wrapper
```sh
./mvnw spring-boot:run  # Linux/macOS
mvnw.cmd spring-boot:run  # Windows
```

## License
This project is licensed under the **MIT License**.

---
This README serves as a guide for installation, setup, and development for contributors and users of the blogging backend API.
