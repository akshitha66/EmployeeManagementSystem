# 🧑‍💼 Full Stack Employee Management System

A complete **CRUD web application** to manage employee records using a **React frontend** and a **Spring Boot backend** with a **MySQL database**.

## ✨ Features

### ✅ Frontend (React)
- View employee list
- Add a new employee
- Edit employee details
- Delete employee
- Responsive UI with modern design

### ✅ Backend (Spring Boot)
- RESTful API for CRUD operations
- MySQL integration via Spring Data JPA
- Layered architecture (Controller, Service, Repository)
- Error handling and validation

---

## 🛠️ Tech Stack

| Layer       | Technology                  |
|-------------|-----------------------------|
| Frontend    | React, Axios, React Router  |
| Backend     | Spring Boot, Spring Data JPA|
| Database    | MySQL                       |
| Tools       | Postman, IntelliJ, VS Code  |
| Build Tools | Maven (Backend), npm (Frontend) |

---

## 🗂️ Project Structure

EmployeeManagementSystem/
├── backend/ (Spring Boot)
│ ├── src/
│ └── pom.xml
├── frontend/ (React)
│ ├── src/
│ └── package.json
└── README.md


---

## ⚙️ Getting Started

### 🔧 Backend Setup (Spring Boot)

1. **Navigate to backend folder:**
   ```bash
   cd backend
   
**2. Configure application.properties:**
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

**3. Create MySQL database:**
CREATE DATABASE employee_db;

**4. Run the app:**
./mvnw spring-boot:run

API runs at: http://localhost:8080/api/employees

Frontend Setup (React)
Navigate to frontend folder:

bash
Copy
Edit
cd frontend
Install dependencies:

bash
Copy
Edit
npm install
Start the React app:

bash
Copy
Edit
npm start
React will run at: http://localhost:3000

🔁 API Endpoints
Method	Endpoint	Description
GET	/api/employees	Get all employees
POST	/api/employees	Add new employee
GET	/api/employees/{id}	Get employee by ID
PUT	/api/employees/{id}	Update employee
DELETE	/api/employees/{id}	Delete employee
