-- Step 1: Create the database
CREATE DATABASE IF NOT EXISTS atm_simulation;
USE atm_simulation;

-- Step 2: Create 'users' table
CREATE TABLE IF NOT EXISTS users (
    account_number INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    pin INT NOT NULL,
    balance DOUBLE DEFAULT 0.0
);

-- Step 3: Create 'transactions' table
CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number INT NOT NULL,
    type ENUM('DEPOSIT', 'WITHDRAW') NOT NULL,
    amount DOUBLE NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES users(account_number)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Step 4: Insert a sample user
INSERT INTO users (account_number, name, pin, balance)
VALUES (123456, 'Aswin Kumar', 1234, 5000.00);

-- Step 5: Insert a few sample transactions
INSERT INTO transactions (account_number, type, amount)
VALUES 
(123456, 'DEPOSIT', 1000.00),
(123456, 'WITHDRAW', 500.00);

SELECT * FROM user;