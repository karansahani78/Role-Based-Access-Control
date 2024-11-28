# Overview
This project implements a Role-Based Access Control (RBAC) system using Spring Boot.
The system provides secure authentication and authorization for users based on predefined roles such as Admin, Moderator, and User.

## Features
User registration and login functionality.
JWT-based authentication.
Role-based authorization with role-specific permissions:
Admin: Full access to manage users and system settings.
Moderator: Limited access to manage content.
User: Basic access to interact with the application.

## Technologies Used
Spring Boot: Backend framework.
PostgreSQL: Database for storing user and role data.
Spring Security: For authentication and authorization.
JWT: For secure session management.
Maven: Dependency management.

## Setup Instructions
  Prerequisites
  Java 17 or higher
  Maven
  PostgreSQL installed and running
  # Database Configuration
  
 1. # Update the application.properties file with your PostgreSQL configuration:
       spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
      spring.datasource.username=your_database_username
       spring.datasource.password=your_database_password
      spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
     jwt.secret=your_jwt_secret_key

  # Run the Application
  1. ### Clone the repository:
    git clone <repository_url>
  
  2. ### Navigate to the project directory
     cd RBAC
  3. ### Install dependencies and run the application
      mvn spring-boot:run
  4. ### Access the application at:
     http://localhost:8080

# API Endpoints

# Swagger UI Documentation 
  ### API Documentation
Access the Swagger UI for detailed API documentation and testing:
  ### http://localhost:8080/swagger-ui/index.html
   ### http://localhost:8080/v3/api-docs
   ![Swagger  2](https://github.com/user-attachments/assets/52d21fd2-679c-4678-a781-3f526c37e0b5)
   





  





