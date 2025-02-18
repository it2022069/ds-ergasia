# Real Estate Management System
## Overview
This project is a Real Estate Management System
that allows owners to create real estates and manage rental requests
while users can search for real estates and make rental requests to them.
Admins oversee the platform by verifying users and managing real estates.
## Features
- Authentication & Authorization
- User login & registration (Users, Owners, Admin)
- Role-based access control with Spring Security
- **Users** can:
    - View available real estates: Browse all approved real estates listed on the platform.
    - Rent a real estate: Apply to rent a real estate.
- **Owners** can:
    - View own real estates: Owners can see only the real estates they have listed.
    - Add new real estate: Owners can submit new real estate listings by providing key details (city, address, type, description, size and price).
    - Edit real estate details: Owners can update specific fields (type, description, size, price).
    - Delete real estates: Owners can remove their real estates from the platform.
    - Approve or decline rental requests: Owners can review all rental requests for their real estates.
- **Admins** can:
    - Approve or reject new real estate listings: Admins review real estate listings before they become visible.
    - Manage users: Admins can view all users and modify their details (email, username) and they can also create new users by entering their username, email, and password.
    - Manage roles: Admins can add or remove roles (User, Owner, Admin) from any account.
### Tech Stack
- <b>Backend:</b> Spring Boot (Java), Hibernate (JPA), PostgreSQL
- <b>Frontend:</b> Thymeleaf
- <b>Security:</b> Spring Security
### 1. Installation & Setup
- Clone the Repository
```sh
git clone https://github.com/it2022069/ds-ergasia.git
```
### 2. Configure the Database
Modify the application.properties file with your database:
```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```
### 3. Run the Application
