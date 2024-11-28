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
    git clone https://github.com/karansahani78/Role-Based-Access-Control.git
  
  2. ### Navigate to the project directory
     cd RBAC
  3. ### Install dependencies and run the application
      mvn spring-boot:run
  4. ### Access the application at:
     http://localhost:8080

# JSON Payload Examples
 1. ### Register a User
  ![User json payload 2](https://github.com/user-attachments/assets/883d933f-5129-4cb3-a80c-07c720adcd48)
   ### Response
   ![Response](https://github.com/user-attachments/assets/71826bca-a242-47df-a70d-876fb920eec4)


 4. ###  Add a New Admin
  ![IMG_0290](https://github.com/user-attachments/assets/2aeddc63-9f11-4ada-b6ea-21c882623e56)
  ### Successful Response
  ![Successful](https://github.com/user-attachments/assets/2fae4e92-1adc-4d5b-83a7-c043dbfef7c4)
  ### failed Response
  ![failed](https://github.com/user-attachments/assets/11ce3453-315f-48a8-a475-90bbf1a54245)


  

  
 

# Testing Credentials
### Here are some default credentials for testing:
1. ### Admin:
email:sohanyadav238@gmail.com
Password: admin

   




# Swagger UI Documentation 
  ### API Documentation
Access the Swagger UI for detailed API documentation and testing:
  ### http://localhost:8080/swagger-ui/index.html
   ### http://localhost:8080/v3/api-docs
   ![Swagger  2](https://github.com/user-attachments/assets/52d21fd2-679c-4678-a781-3f526c37e0b5)
   

# Postman Testing Screenshots
1. We are created intially an admin using commandline runner
![admin](https://github.com/user-attachments/assets/0978a708-70e5-49c2-80c0-f7e25fc6d3be)

2. ### User SignUp
![SignUp](https://github.com/user-attachments/assets/35e9243b-94f5-4757-8e84-c9858a47e984)

3. ### User SignedIn with email and password to generate token
  ![User signedInp](https://github.com/user-attachments/assets/a2523819-0be0-43fe-a97c-d9939813d961)

4. ### User SignedIn with jwt token
  ![User SignedIn with jwt token](https://github.com/user-attachments/assets/def4fa29-9f58-44fe-a8a5-7cf19124d4a0)
  
5. ### Admin SignedIn with email and password
   

7. ### Admin SignedIn with Jwt token
   ![Admin SignedIn with Jwt token](https://github.com/user-attachments/assets/84e6878d-c1d6-4291-8ae2-bca179a9c956)


# Database Screenshots
![Database](https://github.com/user-attachments/assets/9bc83564-d4a0-4ddb-b3fa-8aefa0119745)

# How to Contribute
1. ### Fork the repository.
2. ### Create a feature branch:
   git checkout -b feature/your-feature-name
3. ### Commit your changes:
   git commit -m "Add your message"
4. ### Push to the branch
   git push origin feature/your-feature-name
5. ### Open a pull request.

# License
This project is developed by Karan Sahani. Feel free to contact me at my email for any queries.

# Contact
If you have any questions or feedback, please feel free to contact me at:

Email: karansahani723@gmail.com




  
  
 
  
 




  





