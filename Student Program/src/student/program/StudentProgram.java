package student.program;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentProgram {

    public static Map<String, storeItems> storeItemBuilder = new HashMap<String, storeItems>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        storeItems banana = new storeItems("Banana", 0.50, 100);
        storeItems eggs = new storeItems("Eggs", 1.00, 50);
        storeItems grapes = new storeItems("Grapes", 1.25, 100);
        storeItems orange = new storeItems("Orange", 0.99, 75);

        ArrayList<storeItems> list = new ArrayList<storeItems>();

        Collections.addAll(list, eggs, banana);

        System.out.println("Welcome to my example program!");

        while (true) {
            System.out.println("Available commands: \n*start*\n*quit*");

            String menuChoice = reader.nextLine();

            if (menuChoice.equals("quit")) {
                break;
            } else if (menuChoice.equalsIgnoreCase("start")) {
                System.out.println("What is your name?");
                String userName = reader.nextLine();
                System.out.println("Hi there, " + userName + "!");

                System.out.println("How much money do you have? ");
                double userMoney = reader.nextDouble();
                reader.nextLine();

                cardCreator user1 = new cardCreator(userName, userMoney);
                System.out.println("\nNew card created!\n");
                System.out.println(user1 + "\n");
                pressEnter();

                while (true) {
                    System.out.println("\nAvailable menus: \n*" + userName + "'s card*\n*store*\n*main menu*");

                    String userMenu = reader.nextLine();

                    if (userMenu.startsWith(userName) || userMenu.endsWith("card")) {

                        while (true) {
                            System.out.println("\nAvailable options: \n*check balance*\n*deposit*\n*go back*");

                            String cardMenu = reader.nextLine();

                            if (cardMenu.equalsIgnoreCase("check balance")) {
                                System.out.println();
                                System.out.println(user1 + "\n");
                                pressEnter();

                            } else if (cardMenu.equalsIgnoreCase("deposit")) {
                                System.out.println();
                                System.out.println("How much would you like to desposit? ");
                                double userDeposit = reader.nextDouble();
                                reader.nextLine();

                                user1.deposit(userDeposit);
                                System.out.println();
                                System.out.println(user1 + "\n");
                                pressEnter();

                            } else if (cardMenu.equalsIgnoreCase("go back")) {
                                break;
                            }
                        }

                    } else if (userMenu.equalsIgnoreCase("store")) {

                        while (true) {
                            System.out.println("\nAvailable options: \n*purchase*\n*store options*\n*go back*");
                            String storeMenu = reader.nextLine();

                            if (storeMenu.equalsIgnoreCase("store options")) {
                                while (true) {

                                    System.out.println("\nAvailable options: \n*create new item*\n*check stock*\n*delete items*\n*change items*\n*go back*");
                                    String userStoreOptions = reader.nextLine();

                                    if (userStoreOptions.equalsIgnoreCase("create new item")) {

                                        // Creates a new storeItems object by asking user for info using scanner and then stores the new item in ArrayList<storeItems> list
                                        System.out.println("Enter item name: ");
                                        String newItemName = reader.nextLine();
                                        System.out.println("Enter item price: ");
                                        double newItemPrice = Double.parseDouble(reader.nextLine());
                                        System.out.println("Enter initial item quantity: ");
                                        int newItemStock = Integer.parseInt(reader.nextLine());

                                        storeItems newItem = new storeItems(newItemName, newItemPrice, newItemStock);
                                        System.out.println("Item created!");
                                        System.out.println(newItem + "\n");
                                        list.add(newItem);

                                        pressEnter();
                                    }
                                    if (userStoreOptions.equalsIgnoreCase("check stock")) {
                                        System.out.println("\n" + list);
                                    }
                                    if (userStoreOptions.equalsIgnoreCase("go back")) {
                                        break;
                                    }
                                }
                            }
                            if (storeMenu.equalsIgnoreCase("purchase")) {

                                // Lets the user see all the items from ArrayList<storeItems> list, and lets the user input a string to select the item for purchase
                                while (true) {
                                    System.out.println("Available options: \n*list and purchase items*\n*go back*");
                                    String purchaseOptions = reader.nextLine();

                                    if (purchaseOptions.contains("list") || purchaseOptions.contains("purchase")) {
                                        while (true) {
                                            System.out.println(list);
                                            System.out.println("What would you like to purchase? ");
                                            String userPurchaseAns = reader.nextLine();
                                            // I'm using a forE loop to compare the user's answer to the name of the storeItems objects contained in ArrayList<storeItems> list
                                            // If a match is found, it moves on to ask the user how much they want to purchase
                                            for (storeItems buyItem : list) {
                                                if (buyItem.getItemName().equalsIgnoreCase(userPurchaseAns)) {

                                                    System.out.println("There are " + buyItem.getItemStock() + " of " + buyItem.getItemName() + " available, at a price of " + buyItem.getItemPrice() + " per unit.");
                                                    System.out.println("How many would you like to purchase?");
                                                    int userQuantity = Integer.parseInt(reader.nextLine());
                                                    double purchaseTotal = buyItem.getItemPrice() * userQuantity;
                                                    System.out.println("Buying " + userQuantity + " at " + buyItem.getItemPrice() + " per unit for a total of " + purchaseTotal + "... Is that okay? Y/N");
                                                    reader.nextLine();
                                                    char purchaseConfirmation = reader.next().charAt(0);

                                                    if (confirm(purchaseConfirmation) && user1.payment(purchaseTotal, buyItem, userQuantity)) {
                                                        System.out.println("New item stock: " + buyItem.checkStock() + "\n");
                                                        System.out.println(user1);
                                                    } else {
                                                        System.out.println("Transaction canceled.");
                                                        System.out.println("Item stock: " + buyItem.checkStock() + "\n");
                                                        System.out.println(user1);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    if (purchaseOptions.equalsIgnoreCase("go back")) {
                                        break;
                                    }
                                }

                            }
                            if (storeMenu.equalsIgnoreCase("go back")) {
                                break;
                            }
                        }

                    } else if (userMenu.equalsIgnoreCase("main menu")) {
                        System.out.println("Are you sure you want to return to the main menu? Y/N ALL PROGRESS WILL BE LOST BECAUSE I DON'T KNOW HOW TO STORE USER CHOICES FOR LATER USE YET");
                        char mainMenu = reader.next().charAt(0);
                        reader.nextLine();
                        if (confirm(mainMenu)) {

                            break;
                        } else {
                            continue;
                        }

                    }
                }
            }
        }
        System.out.println("Thanks for using my program!");
        System.out.println("Press ENTER to close...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public static boolean confirm(char userAns) {
        if (userAns == 'y' || userAns == 'Y') {
            return true;
        } else {
            return false;
        }
    }

    public static void pressEnter() {
        System.out.println("Press ENTER key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
