package student.program;

import java.util.ArrayList;

public class storeItems {

    private String itemName;
    private int itemStock;
    private double itemPrice;
    private int amntSold = 0;

    storeItems(String itemName, double itemPrice, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public void storeItems(String itemName, double itemCost, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemCost;
        this.itemStock = itemStock;
    }

    public void purchase(double amount, int quantity) {
        if (amount == (itemPrice * quantity) && itemStock > quantity) {
            itemStock -= quantity;
            amntSold += quantity;
        } else if (amount != (itemPrice * quantity)) {
            System.out.println("*improper funds*");
        } else if (quantity > itemStock) {
            System.out.println("*cannot support stock*");
        } else {
            invalidCommand("sellItem");
        }

    }

    public void addQuantity(int amount) {
        itemStock += amount;
    }

    public void checkStock() {
        System.out.println("Stock " + itemStock);
    }

    public void changePrice(int newItemPrice) {
        this.itemPrice = newItemPrice;
    }

    public void invalidCommand(String errorLoc) {
        System.out.println("*invalid command (" + errorLoc + ")*");
    }

    public void resetAmntSold() {
        amntSold = 0;
    }

    public void checkGross() {
        System.out.println("Gross: " + (amntSold * itemPrice));
        System.out.println("Amount sold: " + amntSold);
    }

    @Override
    public String toString() {

        return "Item name: " + itemName + " | Ammount Sold: " + amntSold + " | Gross income: " + (amntSold * itemPrice);
    }
}
