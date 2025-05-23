# Spring Boot CRUD Demo – User Management

This is a simple **Spring Boot RESTful API** that demonstrates basic **CRUD operations** (Create, Read, Update, Delete) using **Spring Data JPA** with a MySQL database.

## 🚀 Features

- Create new users
- Fetch all users
- Get a user by ID
- Update existing user details
- Delete a user by ID

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (for testing API)

---

## 📁 Project Structure
![image](https://github.com/user-attachments/assets/03411117-0210-40fe-a580-ec2584f6ce50)


---

## 🔗 API Endpoints

| Method | Endpoint       | Description             |
|--------|----------------|-------------------------|
| GET    | `/users`       | Get all users           |
| GET    | `/users/{id}`  | Get user by ID          |
| POST   | `/users`       | Create a new user       |
| PUT    | `/users/{id}`  | Update user by ID       |
| DELETE | `/users/{id}`  | Delete user by ID       |

---

## 📦 How to Run the Project
-Update MySQL credentials in src/main/resources/application.properties:

![image](https://github.com/user-attachments/assets/e1d76f82-cb9e-4d8e-97d4-280f5ba4a438)

3.Create the database in MySQL:
-Create DATABASE demo;

4.Run the application.

5.Test the API using tools like Postman .
