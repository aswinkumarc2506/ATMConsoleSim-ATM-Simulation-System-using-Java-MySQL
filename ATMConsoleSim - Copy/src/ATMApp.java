import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to ATMConsoleSim ===");
        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        User user = ATMOperations.login(acc, pin);

        if (user == null) {
            System.out.println("Login failed. Please check your credentials.");
            return;
        }

        System.out.println("Login successful. Welcome " + user.getName());

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            //System.out.println("5. New User");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> ATMOperations.checkBalance(user);
                case 2 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    ATMOperations.deposit(user, sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    ATMOperations.withdraw(user, sc.nextDouble());
                }
                case 4 -> ATMOperations.viewTransactions(user.getAccountNumber());
                case 5 -> {
                    System.out.print("Enter Your name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Your PIN : ");
                    // int pin = sc.nextInt();
                    System.out.print("Enter Initial deposit : ");
                    int deposit = sc.nextInt();

                }
                case 6 -> System.out.println("Thank you for using ATMConsoleSim!");
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
