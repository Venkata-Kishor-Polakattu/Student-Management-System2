# 🎓 Student Management System – Spring Boot

A **Student Management System** web application developed using **Spring Boot**, **Hibernate**, **Thymeleaf**, and **MySQL**.  
This project is an upgraded version of a traditional **Spring MVC application**, modernized using **Spring Boot auto-configuration** and a cleaner architecture.


## 📌 Project Description

This application enables users to manage student records through a web interface.  
It supports complete **CRUD operations** such as adding, viewing, updating, and deleting students.

The project follows modern **Spring Boot best practices**, eliminates manual configuration, and uses **Thymeleaf** instead of JSP for the view layer.


## 🧠 Motivation for Upgrade (Spring MVC → Spring Boot)

This project was originally implemented using **Spring MVC**.  
It was later upgraded to **Spring Boot** to:

- Remove manual configuration (`web.xml`, dispatcher setup)
- Reduce boilerplate code
- Simplify dependency management
- Improve startup time and maintainability
- Align with current industry standards

The **core business logic and database layer remain unchanged**, allowing a clear comparison between Spring MVC and Spring Boot development styles.


## 🛠 Tech Stack

### Backend
- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Hibernate ORM**
- **Maven**

### Frontend
- **Thymeleaf**
- **HTML**
- **CSS**

### Database
- **MySQL**

### Server
- **Embedded Tomcat (Spring Boot)**


## ✨ Features

- Create new student records
- View all students
- Update existing student details
- Delete student records
- MVC layered architecture
- Hibernate-based persistence
- Clean UI using Thymeleaf templates


## 🏗 Application Architecture
Browser
↓
Thymeleaf Views
↓
Spring Boot Controllers
↓
Service Layer
↓
DAO / Repository Layer (Hibernate)
↓
MySQL Database


## 📂 Project Structure



Student-Management-System
│
├── src/main/java
│ ├── controller
│ ├── service
│ ├── repository / dao
│ ├── model
│ └── StudentManagementApplication.java
│
├── src/main/resources
│ ├── templates
│ │ └── (Thymeleaf HTML files)
│ ├── static
│ └── application.properties
│
├── pom.xml
└── README.md

## ⚙️ Prerequisites

Ensure the following are installed:

- Java **17**
- Maven
- MySQL
- Any IDE (IntelliJ / Eclipse / STS)

---

## 🗄 Database Configuration

1. Create a database in MySQL:
sql
CREATE DATABASE studentdb;
Update application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
Hibernate will automatically create/update tables.

## How to Run the Application
Step 1: Clone the Repository
git clone https://github.com/Venkata-Kishor-Polakattu/Student-Management-System.git

Step 2: Navigate to Project Directory
cd Student-Management-System

Step 3: Build the Project
mvn clean install

Step 4: Run the Application
mvn spring-boot:run

Step 5: Access in Browser
arduino
http://localhost:8080/


# Functional Flow
1. User submits a request from the browser

2.Spring Boot controller handles the request

3.Service layer processes business logic

4.Hibernate performs database operations

5.Response is rendered using Thymeleaf

