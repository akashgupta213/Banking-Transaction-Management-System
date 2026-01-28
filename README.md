# 🏦 Java Bank Console | JDBC + MySQL Edition

## 📋 Overview
This is a simple **Banking App** developed in Java that allows users to perform basic bank account management operations via a console interface. It connects to a MySQL database to persist account data.

### ✨ Key Features:
- ➕ Add new bank accounts
- 🔍 View details of a specific account
- ✏️ Update account information
- ❌ Delete an account
- 📜 View all accounts stored in the database

## 📁 Project Structure
- `BankMain.java` — Main class with the interactive console menu and user input handling.
- `model.Account` — Java class representing the bank account entity.
- `service.Service` — Handles database connection and CRUD operations using JDBC.
## 🏦 Banking App Architecture Diagram

~~~~
+------------------+        +-----------------+        +------------------+
|  BankMain.java   | -----> |   Service.java  | -----> |    MySQL DB      |
|  (User Interface) |        | (DB Operations) |        |  (bank table)    |
+------------------+        +-----------------+        +------------------+
        |                           ^
        |                           |
        v                           |
+------------------+                |
|   Account.java   |----------------+
| (Account Model)  |
+------------------+
~~~~

**Explanation:**

- `BankMain.java` handles user interaction via console menus.
- It calls methods from `Service.java` to perform CRUD operations.
- `Service.java` connects to the MySQL database to store/retrieve account data.
- `Account.java` represents the data structure for a bank account.

## 🛠️ Technologies Used
- ☕ Java SE
- 🔌 JDBC for database connectivity
- 🐬 MySQL database
- 🖥️ Console-based user interface

## ✅ Prerequisites
- ☕ Java Development Kit (JDK) installed
- 🐬 MySQL Server installed and running
- 📦 MySQL Connector/J (JDBC driver) added to your project dependencies  
  **Important:** Add the MySQL Connector/J `.jar` file to your project build path to enable database connectivity
- 🗄️ A database created with the following table:

```sql
CREATE DATABASE DBName;

USE DBName;

CREATE TABLE bank (
    acc_number VARCHAR(20) PRIMARY KEY,
    cust_name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);
```
## ⚙️ Setup Instructions

### 📥 Clone the repository

```bash
git clone https://github.com/yourusername/banking-app.git
cd banking-app

```
### 🛠️ Configure Database Connection

Open the `service.Service` class and update the following variables with your MySQL credentials and database name:

```java
String url = "jdbc:mysql://localhost:3306/DBName";
String user = "your_userName";
String password = "your_mysql_password";
```
### 📦 Add MySQL JDBC Driver

Make sure the MySQL Connector/J `.jar` file is included in your project’s build path.

⚠️ This is important for database connectivity.

### 🚀 Compile and Run the Application

```bash
javac -d bin src/**/*.java
java -cp "bin;path_to_mysql_connector.jar" main.BankMain
```
*Note:* Replace `path_to_mysql_connector.jar` with the actual path to your MySQL Connector/J jar file.

## 📝 How to Use

Run the application.

You will see a menu with options to:

- Add bank accounts
- View bank accounts
- Update bank accounts
- Delete bank accounts
- List all bank accounts

Input your choice as a number and follow the prompts.

The app performs requested operations directly on the MySQL database.

To exit, choose option `6`.

## 🚀 Future Enhancements

- Add transaction management (deposit/withdraw)
- Implement input validations and exception handling
- Add a graphical user interface (GUI)
- Support multiple users with authentication


## ✍️ Author

Shruti Parikshit Sangvikar  
3rd Year Engineering Student

