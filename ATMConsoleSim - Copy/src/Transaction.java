import java.sql.Timestamp;

public class Transaction {
    private String type;
    private double amount;
    private Timestamp timestamp;

    public Transaction(String type, double amount, Timestamp timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String toString() {
        return timestamp + " | " + type + " | ₹" + amount;
    }
}
