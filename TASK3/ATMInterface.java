import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number between 1 and 4.");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", account.getBalance());
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Enter a numeric value.");
            sc.next();
        }
        double amount = sc.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Enter a numeric value.");
            sc.next();
        }
        double amount = sc.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000); 
        ATM atm = new ATM(account);                  
        atm.start();                                 
    }
}
