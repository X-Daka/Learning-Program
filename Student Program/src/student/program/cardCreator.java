package student.program;

import java.util.ArrayList;
import java.util.Scanner;

public class cardCreator {

    private String owner;
    private double initialBal;
    private double balance;
    private int transactions;

    cardCreator(String name, double amount) {
        this.owner = name;
        this.initialBal = amount;
    }

    public void cardCreator(String owner, double initialBal) {
        this.owner = owner;
        this.initialBal = initialBal;
    }

    public void checkBal() {
        System.out.println("Balance: " + balance);
        System.out.println("Transaction count: " + transactions);
    }

    public void payment(double amount) {
        if (amount <= balance && amount > 0) {
        balance -= amount;
        transactions++;
        } else if (amount > balance) {
            System.out.println("*insufficient funds*");
        } else {
            invalidCommand("payment");
        }
    }
    
    public void changeOwner(String newOwner) {
        this.owner = newOwner;
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactions++;
    }
    public void invalidCommand(String errorLoc) {
        System.out.println("*invalid command (" + errorLoc + ")*");
        
    }
    
    @Override
    public String toString() {
        
        return "Owner: " + owner + " | Balance: " + balance + " | Amount of transactions: " + transactions;
    }
}
