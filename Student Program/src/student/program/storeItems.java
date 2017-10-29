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
    
    public String getItemName() {
        
        return itemName;
    }
    
    public double getItemPrice() {
        
        return itemPrice;
    }
    
    public int getItemStock() {
        
        return itemStock;
    }

    public boolean purchase(double amount, int quantity) {
        if (amount == (itemPrice * quantity) && itemStock >= quantity) {
            itemStock -= quantity;
            amntSold += quantity;
            return true;
        } else if (amount != (itemPrice * quantity)) {
            System.out.println("*improper funds*");
            return false;
        } else if (quantity > itemStock) {
            System.out.println("*cannot support stock*");
            return false;
        } 
        return false;
    }

    
    public void addQuantity(int amount) {
        itemStock += amount;
    }

    public int checkStock() {
       return itemStock;
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
    
    public String itemStats() {
        
        return "Item name: " + itemName + " | Ammount Sold: " + amntSold + " | Gross income: " + (amntSold * itemPrice);
    }

    @Override
    public String toString() {

        return "Item name: " + itemName + " | Item price: " + itemPrice + " | Item stock: " + itemStock;
    }
}
