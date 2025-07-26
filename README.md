# ATMConsoleSim-ATM-Simulation-System-using-Java-MySQL
A console-based ATM Simulation System developed using Java and MySQL. This project simulates core ATM functionalities like user login, balance check, cash withdrawal, deposit, and transaction history in a secure and user-friendly way.
🔧 Technologies Used
Java – Core logic and console interaction

MySQL – Database for storing user details and transactions

JDBC – For connecting Java application with MySQL

OOP Concepts – Used throughout the code for modularity and reusability

✅ Features
🔐 User authentication (ATM Number + PIN)
💰 Balance inquiry
💸 Cash withdrawal and deposit
📜 Mini statement (Transaction history)
🧾 User registration
❌ Safe exit and error handling

📁 Project Structure
pgsql
Copy
Edit
ATMConsoleSim/
├── src/
│   ├── Main.java
│   ├── ATMService.java
│   ├── DBConnection.java
│   └── Models/
│       ├── User.java
│       └── Transaction.java
├── sql/
│   └── atm_database.sql
└── README.md

🛠️ Setup Instructions
Clone the repository:
bash
Copy
Edit
git clone https://github.com/aswinkumarc2506/ATMConsoleSim-ATM-Simulation-System-using-Java-MySQL
cd ATMConsoleSim
Import atm_database.sql into your MySQL server.

Update DB credentials in DBConnection.java.

Compile and run the application:

bash
Copy
Edit
javac Main.java
java Main

📌 Use Case
Perfect for Java beginners or students wanting hands-on experience with:
Java-MySQL integration
OOP implementation
Console-based applications

📷 Screenshots
You can add CLI screenshots of login, deposit, withdrawal, and transaction history for better understanding.

🤝 Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change
