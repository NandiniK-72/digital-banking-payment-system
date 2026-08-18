# 🏦 Digital Banking & Payment System

A secure and scalable banking application built using **Java 17, Spring Boot 3, Spring Security, JWT, Hibernate (JPA), MySQL, and Maven**. The system enables customer management, account operations, fund transfers, and transaction tracking with role-based security.

## 🚀 Features

### 🔐 Authentication & Security
- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- Role-Based Access Control (ADMIN, CUSTOMER)

### 👤 Customer Management
- Register & Login
- Create, Update, Delete Customers
- View Customer Details

### 🏦 Account Management
- Savings & Current Accounts
- Account Creation
- Balance Inquiry
- Account Status Management

### 💸 Transaction Management
- Deposit Money
- Withdraw Money
- Fund Transfer
- Transaction History

### ⚙️ Additional Features
- RESTful APIs
- Global Exception Handling
- Request Validation
- Layered Architecture
- Transaction Management (`@Transactional`)

---

## 🛠️ Tech Stack

| Technology | Description |
|------------|-------------|
| Java 17 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Token-Based Security |
| Hibernate/JPA | ORM Framework |
| MySQL | Database |
| Maven | Build Tool |
| Postman | API Testing |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```text
src/main/java/com/bank
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── security
├── config
└── util
```

---

## 🗄️ Database Modules

- Roles
- Users
- Customers
- Accounts
- Transactions

### Entity Flow

```text
ROLE → USER → CUSTOMER → ACCOUNT → TRANSACTION
```

---

## 🔐 Authentication Flow

```text
Register User
      ↓
Encrypt Password
      ↓
Login
      ↓
Generate JWT Token
      ↓
Access Protected APIs
```

---

## ⚙️ Setup

### Clone Repository

```bash
git clone https://github.com/yourusername/digital-banking-payment-system.git
cd digital-banking-payment-system
```

### Create Database

```sql
CREATE DATABASE digital_banking_db;
```

### Run Application

```bash
mvn clean install
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

---

## 📮 Main API Endpoints

### Authentication
- `POST /api/auth/register`
- `POST /api/auth/login`

### Customers
- `GET /api/customers`
- `GET /api/customers/{id}`
- `PUT /api/customers/{id}`
- `DELETE /api/customers/{id}`

### Accounts
- `POST /api/accounts`
- `GET /api/accounts/{id}`
- `GET /api/accounts/balance`

### Transactions
- `POST /api/transactions/deposit`
- `POST /api/transactions/withdraw`
- `POST /api/transactions/transfer`
- `GET /api/transactions/history`

---

## 🛡️ Security Features

✅ JWT Authentication  
✅ Spring Security Filters  
✅ BCrypt Password Encryption  
✅ Stateless Sessions  
✅ Role-Based Authorization  

---

## ⚠️ Exception Handling

- ResourceNotFoundException
- AccountNotFoundException
- InsufficientBalanceException

---

## 🔮 Future Enhancements

- UPI Integration
- QR Code Payments
- Email & SMS Notifications
- Docker Deployment
- AWS Deployment
- Microservices Architecture
- Kafka Integration

---
