import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " has been deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is $" + balance);
            return false;
        }
        
        balance -= amount;
        System.out.println("$" + amount + " has been withdrawn successfully.");
        return true;
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

class ATM {
    private Map<String, Account> accounts;
    private Account currentAccount;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
        
        addAccount(new Account("1001", "John Doe", 5000.0));
        addAccount(new Account("1002", "Jane Smith", 7500.0));
        addAccount(new Account("1003", "Mike Johnson", 3200.0));
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean login() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        
        if (accounts.containsKey(accountNumber)) {
            currentAccount = accounts.get(accountNumber);
            System.out.println("Welcome, " + currentAccount.getAccountHolderName() + "!");
            return true;
        } else {
            System.out.println("Invalid account number. Please try again.");
            return false;
        }
    }

    public void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                currentAccount.checkBalance();
                break;
            case 2:
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                scanner.nextLine();
                currentAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                scanner.nextLine(); 
                currentAccount.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Thank you for using our ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void start() {
        System.out.println("Welcome to the ATM System");
        
        while (true) {
            if (currentAccount == null) {
                boolean loggedIn = login();
                if (!loggedIn) {
                    continue;
                }
            }
            
            showMenu();
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine(); 
                processOption(option);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}