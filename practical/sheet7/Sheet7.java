package sheet7;

import java.util.Scanner;

class BankAccount {
    
    private String accountNumber;
    private String accountHolder;
    private double balance;

    
    public BankAccount() {
        this.accountNumber = "0000";
        this.accountHolder = "Unknown";
        this.balance = 0.0;
    }

    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
        else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
        else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}

public class Sheet7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter Account Number: ");
        String accNum = input.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holder = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        
        BankAccount account = new BankAccount(accNum, holder, initialBalance);

        
        System.out.print("Enter amount to deposit: ");
        double depAmount = input.nextDouble();
        account.deposit(depAmount);

        System.out.print("Enter amount to withdraw: ");
        double withAmount = input.nextDouble();
        account.withdraw(withAmount);

        
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Current Balance: " + account.getBalance());
        
        input.close();
    }
}