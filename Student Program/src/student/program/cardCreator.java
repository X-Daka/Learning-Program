package student.program;

import java.util.ArrayList;
import java.util.Scanner;

public class cardCreator {

    private String owner;
    private double initialBal;
    private double balance;
    private int transactions = 1;

    cardCreator(String name, double amount) {
        this.owner = name;
        this.initialBal = amount;
        this.balance = initialBal;
    }
    
    public double getBalance() {
    
        return balance;
    }

    public boolean payment(double amount, storeItems item, int quantity) {
        if (amount <= balance && amount > 0 && item.purchase(amount, quantity)) {
        balance -= amount;
        transactions++;
        return true;
        } else if (amount > balance) {
            System.out.println("*insufficient funds*");
            return false;
        } else {
            return false;
        }
    }
    
    public void changeOwner(String newOwner) {
        this.owner = newOwner;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
        balance += amount;
        transactions++;
        } else if (amount < 0) {
            System.out.println("\nYou can't deposit negative money!\n");
        } else if (amount == 0) {
            System.out.println("\nYou can't deposit no money!\n");
        }
    }
    public void invalidCommand(String errorLoc) {
        System.out.println("*invalid command (" + errorLoc + ")*");
        
    }
    
    @Override
    public String toString() {
        
        return "Owner: " + owner + " | Balance: " + balance + " | Amount of transactions: " + transactions;
    }
}
