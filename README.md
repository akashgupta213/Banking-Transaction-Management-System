🏦 Java Banking System | JDBC + MySQL Console Application

📋 Overview

This is a lightweight Java-based Banking Management System that enables users to perform essential bank account operations through a console interface. The application uses JDBC to connect with a MySQL database for secure data storage and retrieval.

✨ Key Features:

➕ Create new bank accounts

🔍 Retrieve account details by account number

✏️ Modify customer and balance information

❌ Remove existing accounts

📜 Display all stored bank records

📁 Project Structure

BankMain.java — Entry point of the application with interactive menu handling

model.Account — Model class representing customer account details

service.Service — Manages JDBC connection and database CRUD operations
Explanation:

-BankMain.java handles user inputs and menu navigation
-Service.java performs database operations using JDBC
-MySQL stores all account records securely
-Account.java defines the bank account entity

##🛠️ Technologies Used

☕ Java SE
🔌 JDBC (Java Database Connectivity)
🐬 MySQL Database
🖥️ Console-Based Interface
✅ Prerequisites
☕ Java JDK installed
🐬 MySQL Server running
📦 MySQL Connector/J added to project build path

##🗄️ Database created using the following schema:

CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE bank (
    acc_number VARCHAR(20) PRIMARY KEY,
    cust_name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

⚙️ Setup Instructions
📥 Clone the repository
git clone [https://github.com/yourusername/banking-system.git](https://github.com/akashgupta213/Banking-Transaction-Management-System)
cd banking-system

##🛠️ Configure Database Connection

Update credentials inside service.Service:

String url = "jdbc:mysql://localhost:3306/banking_system";

String user = "your_username";

String password = "your_password";

##📦 Add JDBC Driver

Ensure MySQL Connector/J .jar file is included in your project libraries.

##🚀 Run the Application
-javac -d bin src/**/*.java
-java -cp "bin;path_to_mysql_connector.jar" main.BankMain

##📝 How to Use

1.)Launch the application and choose options from the menu to:
2.)Create accounts
3.)View account details
3.)Update records
4.)Delete accounts
5.)List all accounts
6.)Enter the corresponding number and follow prompts.
7.)Exit using option 6.

##🚀 Future Enhancements

-Deposit and withdrawal transactions
-Input validation and exception handling
-Web-based version using Spring Boot
-User authentication system

##✍️ Author

Akash Chandra Gupta
Computer Science Graduate
