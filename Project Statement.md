# Banking Portal – Project Statement

## 1. Project Title

**Banking Portal API**

## 2. Project Overview

The Banking Portal is a web-based application designed to provide basic banking services through a secure and easy-to-use system. It allows users to create accounts, manage their PINs, deposit and withdraw money, transfer funds, and view their transaction history.

The system provides REST APIs through which users can perform banking operations. Authentication is implemented using **Bearer Token authentication**, ensuring that only authorized users can access protected services.

## 3. Problem Statement

Traditional banking operations may require users to perform multiple activities through different systems. Managing account information, transactions, deposits, withdrawals, and fund transfers can become difficult without a centralized system.

The aim of this project is to develop a **secure Banking Portal API** that brings these basic banking operations together in one system. The application should provide controlled access to user accounts and maintain transaction records while handling common banking errors such as insufficient balance, unauthorized access, and account not found.

## 4. Objectives

The main objectives of the project are:

* To provide secure user registration and login.
* To allow users to manage their account PIN.
* To provide deposit and withdrawal facilities.
* To enable fund transfers between accounts.
* To maintain and display transaction history.
* To protect APIs using authentication.
* To handle banking errors using proper exception handling.
* To provide a structured REST API for banking operations.

## 5. Main Features

### User Registration

Users can register by providing:

* Name
* Email
* Password
* Address
* Phone number

### User Login

Users can log in using their account number and password and receive an authentication token.

### PIN Management

Users can:

* Create a PIN
* Check their PIN
* Update their existing PIN

### Deposit

Users can add money to their bank account through the deposit API.

### Withdrawal

Users can withdraw money after successful authentication and PIN verification.

### Fund Transfer

Users can transfer money from their account to another account within the system.

### Transaction History

Users can view their previous banking transactions.

### Account Details

Authenticated users can view their account and personal information.

## 6. Technologies Used

The project is based on a **Java Spring Boot REST API** architecture and uses technologies such as:

* **Java** – Main programming language
* **Spring Boot** – Backend framework
* **Spring REST** – API development
* **MySQL** – Database
* **Maven** – Project build and dependency management
* **JWT/Bearer Token** – Authentication
* **Postman** – API testing
* **Git/GitHub** – Version control and project management

## 7. System Workflow

```text
User
  ↓
Registration
  ↓
Login
  ↓
Authentication Token
  ↓
Access Protected APIs
  ↓
┌───────────────────────┐
│ Account Management    │
│ PIN Management        │
│ Deposit               │
│ Withdrawal            │
│ Fund Transfer         │
│ Transaction History   │
└───────────────────────┘
  ↓
Database
```

## 8. API Modules

| Module         | Operations                    |
| -------------- | ----------------------------- |
| User           | Registration, Login           |
| Account        | Account details               |
| PIN            | Create, Check, Update         |
| Transactions   | Deposit, Withdrawal, Transfer |
| Dashboard      | User and account information  |
| Authentication | Bearer Token authentication   |

## 9. Security

The application uses **Bearer Token authentication** to protect its APIs. Users must provide a valid access token in the `Authorization` header to access protected endpoints.

Example:

```text
Authorization: Bearer <access-token>
```

This prevents unauthorized users from directly accessing protected banking operations.

## 10. Error Handling

The project uses global exception handling to provide meaningful responses when an operation fails.

Common errors include:

* **NotFoundException** – Used when an account or required resource cannot be found.
* **UnauthorizedException** – Used when the user does not have valid authorization.
* **InsufficientBalanceException** – Used when the account does not have enough balance for a transaction.

Example status codes:

```text
404 → Resource/Account Not Found
401 → Unauthorized Access
400 → Invalid Request / Insufficient Balance
```

## 11. Database

The project uses **MySQL** to store application data such as:

* User information
* Account information
* PIN-related information
* Transaction records
* Authentication-related information

The database configuration is maintained in the `application.properties` file.

## 12. Testing

The APIs can be tested using **Postman**. Each endpoint can be tested by providing the required HTTP method, URL, request body, and authorization token.

Examples of operations tested through Postman include:

```text
POST /api/users/register
POST /api/users/login
POST /api/account/pin/create
POST /api/account/pin/update
POST /api/account/deposit
POST /api/account/withdraw
POST /api/account/fund-transfer
GET  /api/account/transactions
GET  /api/dashboard/account
GET  /api/dashboard/user
```

## 13. Future Enhancements

The following features can be added in future versions:

* Fix dashboard chart UI.
* Add pagination to transaction tables.
* Store JWT tokens securely in the database and remove them during logout.
* Send email notifications when a user logs into an account.
* Generate and send bank statements through email.
* Improve the dashboard and user interface.
* Add additional security and validation mechanisms.

## 14. Expected Outcome

The expected outcome of this project is a secure and reliable Banking Portal API that allows users to perform common banking operations digitally. The system provides authentication, account management, money transactions, and transaction tracking through REST APIs while maintaining proper error handling and database management.

## 15. Conclusion

The Banking Portal API provides a centralized platform for performing basic banking operations. By using Java, Spring Boot, MySQL, REST APIs, and token-based authentication, the project demonstrates how a secure backend banking system can be developed. It can also be extended in the future with additional security, email services, improved dashboard features, and other banking functionalities.

