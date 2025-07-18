import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 1000.0;
    private static String userPIN = "1234";

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM System");
        if (authenticateUser()) {
            int option;
            do {
                displayMenu();
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        depositMoney();
                        break;
                    case 4:
                        transferFunds();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 5);
        } else {
            System.out.println("Authentication failed. Exiting.");
        }
    }

    private static boolean authenticateUser() {
        System.out.print("Enter PIN: ");
        String inputPIN = scanner.nextLine();
        return userPIN.equals(inputPIN);
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: Rs%.2f\n", balance);
    }

    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: Rs");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Please collect your cash. New balance: Rs%.2f\n", balance);
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }

    private static void depositMoney() {
        System.out.print("Enter amount to deposit: Rs");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit successful. New balance: Rs%.2f\n", balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void transferFunds() {
        System.out.print("Enter recipient account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: Rs");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Rs%.2f transferred to account %s. New balance: Rs%.2f\n", amount, accountNumber, balance);
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }
}