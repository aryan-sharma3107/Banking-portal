# Banking Portal

The **Banking Portal API** is a Java-based backend application that provides APIs for managing user accounts, banking transactions, and fund transfers. The system is designed to provide secure and efficient banking operations.

## Features

* **User Registration:** Users can register by providing details such as name, email, address, and phone number.
* **User Login:** Users can log in securely and receive an authentication token.
* **PIN Management:** Users can create, check, and update their account PIN.
* **Cash Deposit:** Users can deposit money into their bank account.
* **Cash Withdrawal:** Users can withdraw money from their account.
* **Fund Transfer:** Users can transfer money to other accounts.
* **Transaction History:** Users can view their previous banking transactions.
* **Account Details:** Users can view their account information and balance.
blob:https://web.whatsapp.com/edf412bf-62d1-42f0-8e52-68867ad607d1

## Technologies Used

* **Java** – Main programming language
* **Spring Boot** – Backend framework for developing REST APIs
* **Spring Web** – Used to create RESTful API endpoints
* **Spring Security** – Used for authentication and authorization
* **JWT (JSON Web Token)** – Used for secure bearer-token authentication
* **MySQL** – Database for storing users, accounts, and transactions
* **Maven** – Used for project building and dependency management
* **Postman** – Used for API testing
* **Git & GitHub** – Used for version control and project management

## Authentication

The API uses **Bearer Token Authentication**.

Users must first log in to obtain a valid JWT access token. The token must then be included in the `Authorization` header when accessing protected endpoints.

This helps prevent unauthorized users from accessing protected banking operations.

## API Operations

The Banking Portal provides APIs for the following operations:

### User Management

* User Registration
* User Login
* View User Details

### Account Management

* View Account Details
* Create PIN
* Check PIN
* Update PIN

### Banking Operations

* Deposit Money
* Withdraw Money
* Transfer Funds
* View Transaction History

## Installation and Setup

1. Clone the Repository
2. Navigate to the Project Folder
3. Configure MySQL
4. Build and Run the Project

## Error Handling

The application uses **global exception handling** to manage common errors and return appropriate HTTP status codes.

### Common Exceptions

* **NotFoundException** – Returns `404 Not Found` when the requested user, account, or transaction does not exist.
* **UnauthorizedException** – Returns `401 Unauthorized` when the user is not properly authenticated or does not have permission.
* **InsufficientBalanceException** – Returns `400 Bad Request` when the account does not have enough balance for a withdrawal or transfer.

## Future Enhancements

The following features can be added in future versions:

* Fix dashboard charts and improve UI
* Add pagination to transaction tables
* Store and manage JWT tokens securely in the database
* Add email notifications for account login
* Send bank statements through email
* Add better input validation
* Improve transaction security and logging

## Project Objective

The main objective of this project is to develop a **secure and user-friendly banking backend using Java and Spring Boot**. It allows users to manage their accounts, perform banking transactions, and securely transfer funds through REST APIs.

## Conclusion

The Banking Portal provides a structured backend system for basic banking operations. By using **Java, Spring Boot, MySQL, JWT, and REST APIs**, the project demonstrates how a secure and scalable banking application can be developed.











