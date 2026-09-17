# Banking-portal
The Banking Portal API provides a set of endpoints for managing user accounts, fund transfers, and transactions. This project aims to facilitate secure and efficient banking operations for users.

The Banking Portal API allows users to perform various banking operations, including managing accounts, fund transfers, and transactions. This document provides details on each API endpoint, its request parameters, response structure, and authentication requirements. It also includes information on error handling and status codes.

Authentication: The API endpoints require bearer token authentication. Users must obtain a valid access token and include it in the "Authorization" header with the "Bearer" scheme to access protected endpoints.

# Features
- User Registration: Users can register by providing their details, such as name, email, address, and phone number.
- PIN Management: Users can create and update their PINs for added security.
- Cash Deposit and Withdrawal: Users can deposit and withdraw cash from their accounts.
- Fund Transfer: Users can transfer funds to other accounts within the system.
- Transaction History: Users can view their transaction history.

# Technologies Used
<img width="313" height="161" alt="302871244-3647613e-1d6e-4bc4-98b6-2da5648659f9" src="https://github.com/user-attachments/assets/eb4a8496-ad4d-4e10-90c2-1135ced1b7a6" />
<img width="306" height="165" alt="302870984-c09bc4ac-c0ca-4f7c-9c6e-8eb9818eb35b" src="https://github.com/user-attachments/assets/e8e99e38-fbdf-4ce2-a2ca-59c5c6fb18f2" />
<img width="315" height="160" alt="302870313-31896d20-16d9-4fe1-a534-0490841de4b9" src="https://github.com/user-attachments/assets/f96aee76-1851-46d6-acdf-766d83d546bb" />

# TODO
- UI Fix for Dashboard Charts
  
- Pagination in table
  
- Save JWT Token in db and remove on logout
  
- Email trigger on account login
  
- Send Bank Statement on Email

# Installation and Setup
1. Clone the repository: git clone https://github.com/yourusername/banking-portal-api.git

2. Navigate to the project folder: cd banking-portal-api

3. Configure MySQL: Set up a MySQL database, create a copy of application.properties.sample, rename it application.properties, and update the properties as needed.

4.  Build and run the project: mvn spring-boot:run


# Error Handling
The API implements global exception handling for common error scenarios, such as account not found, unauthorized access, and insufficient balance.

The API implements global exception handling for the following scenarios:

- NotFoundException: Returns 404 Not Found with an error message.
- UnauthorizedException: Returns 401 Unauthorized with an error message.
- InsufficientBalanceException: Returns 400 Bad Request with an error message.






