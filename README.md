# hospital-management-system-backend
Spring Boot backend for Hospital Management System with REST APIs for patient, doctor, appointment, and billing management

# Hospital Management System - Backend

## 📌 Overview
This project is a backend system for managing hospital operations, including patients, doctors, appointments, and billing. It is built using Spring Boot following a layered architecture.

## 🚀 Features
- Patient Profile Management (CRUD operations)
- Doctor Profile Management
- Appointment Scheduling System
- Billing and Payment Management
- RESTful APIs for all modules

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## 🏗️ Architecture
The project follows a layered architecture:
- Controller Layer (API endpoints)
- Service Layer (business logic)
- Repository Layer (database interaction)

## 📡 API Endpoints

### Patient
- POST /patient
- GET /patient
- GET /patient/{id}
- PUT /patient/{id}
- DELETE /patient/{id}

### Doctor
- POST /doctor
- GET /doctor
- GET /doctor/{id}
- PUT /doctor/{id}
- DELETE /doctor/{id}

### Appointment
- POST /appointment
- GET /appointment
- GET /appointment/{id}
- PUT /appointment/{id}
- DELETE /appointment/{id}

### Billing
- POST /bill
- GET /bill
- GET /bill/{id}
- PUT /bill/{id}
- DELETE /bill/{id}

## ⚙️ Setup Instructions
1. Clone the repository
2. Open in IDE (IntelliJ / VS Code)
3. Configure database in application.properties
4. Run the Spring Boot application

## 📈 Future Enhancements
- Authentication & Authorization (JWT)
- API Documentation (Swagger)
- Deployment on cloud (AWS)

---

## 👩‍💻 Author
Sinchana
