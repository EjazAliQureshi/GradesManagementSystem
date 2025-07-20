
# 📚 Grades Management System

A Spring Boot-based REST API to manage **Students**, **Courses**, **Grades**, and **Enrollments** in an educational setting.

---

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL** 
- **Lombok**
- **Swagger (Springdoc OpenAPI)**
- **Maven**

---

## 🗂️ Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.grades.grades/
    │       ├── controller/
    │       ├── dto/
    │       ├── entity/
    │       ├── repository/
    │       ├── service/
    │       └── config/
    └── resources/
        └── application.properties
```

---

## 📦 Entities

- **Student**
  - `id`, `name`, `email`
- **Course**
  - `id`, `name`, `description`
- **Enrollment**
  - `id`, `student`, `course`, `grade`

> `Enrollment` acts as a join table between `Student` and `Course` with additional `grade` data.

---

## 📘 Features

- 🔁 **CRUD** for Students, Courses, and Enrollments
- 📊 Fetch **grades of students per course**
- 🔍 Get all enrollments or filter by student
- 🧾 Well-structured DTOs to control API data exposure
- 📜 **Swagger UI** for interactive documentation

---

## 🧪 API Endpoints

| Method | Endpoint                          | Description                        |
|--------|-----------------------------------|------------------------------------|
| GET    | `/api/v1/enrollments`             | List all enrollments               |
| GET    | `/api/v1/enrollments/grades`      | List all student grades            |
| GET    | `/api/v1/enrollments/student/{id}/grades` | Grades for specific student |
| POST   | `/api/v1/enrollments`             | Enroll a student in a course       |
| POST   | `/api/v1/students`                | Add a student                      |
| POST   | `/api/v1/courses`                 | Add a course                       |

---

## 📄 Swagger UI

After running the app:

📎 **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Explore and test your APIs interactively.

---

## ⚙️ Configuration (in `application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gradesdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> 💡 Swap to PostgreSQL by updating these properties.

---

## 🧑‍💻 How to Run

```bash
# Build
mvn clean install

# Run
mvn spring-boot:run
```

Or open in **IntelliJ / Eclipse** and run the `GradesApplication` class.

---

## 🧑 Author

**Ejaz Ali** – built with Spring Boot and dedication!
