import java.sql.*;
import java.util.*;

public class ATMOperations {

    public static User login(int acc, int pin) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE account_number = ? AND pin = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, acc);
            ps.setInt(2, pin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(acc, rs.getString("name"), pin, rs.getDouble("balance"));
            }
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }

    public static void checkBalance(User user) {
        System.out.println("Current Balance: ₹" + user.getBalance());
    }

    public static void deposit(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE users SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, user.getAccountNumber());
            ps.executeUpdate();

            user.setBalance(user.getBalance() + amount);
            saveTransaction(user.getAccountNumber(), "DEPOSIT", amount);
            System.out.println("₹" + amount + " deposited.");
        } catch (Exception e) {
            System.out.println("e");
        }
    }

    public static void withdraw(User user, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE users SET balance = balance - ? WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, user.getAccountNumber());
            ps.executeUpdate();

            user.setBalance(user.getBalance() - amount);
            saveTransaction(user.getAccountNumber(), "WITHDRAW", amount);
            System.out.println("₹" + amount + " withdrawn.");
        } catch (Exception e) {
            System.out.println("e");
        }
    }

    public static void viewTransactions(int accNo) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE account_number = ? ORDER BY timestamp DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            List<Transaction> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Transaction(
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp")
                ));
            }

            if (list.isEmpty()) {
                System.out.println("No transactions found.");
            } else {
                System.out.println("--- Transaction History ---");
                for (Transaction t : list) {
                    System.out.println(t);
                }
            }

        } catch (Exception e) {
            System.out.println("e");
        }
    }

    private static void saveTransaction(int accNo, String type, double amount) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO transactions (account_number, type, amount) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accNo);
            ps.setString(2, type);
            ps.setDouble(3, amount);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("e");
        }
    }

    public static void NewUSer(User user, double amount) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (account_number, name, pin, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, accno);
            ps.setDouble(1, bal);
            ps.setString(2, name);
            ps.setInt(2, pin);
            ps.executeUpdate();

            user.setBalance(user.getBalance() + amount);
            saveTransaction(user.getAccountNumber(), "DEPOSIT", amount);
            System.out.println("₹" + amount + " deposited.");
        } catch (Exception e) {
            System.out.println("e");
        }
    }
}
