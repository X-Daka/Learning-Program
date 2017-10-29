package student.program;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentProgram {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        storeItems banana = new storeItems("Banana", 0.50, 100);
        System.out.println("Welcome to my example program!");

        while (true) {
            System.out.println("Available commands: \nstart\nquit");

            String menuChoice = reader.nextLine();

            if (menuChoice.equals("quit")) {
                break;
            } else if (menuChoice.equalsIgnoreCase("start")) {
                System.out.println("What is your name?");
                String userName = reader.nextLine();
                System.out.println("Hi there, " + userName + "!");

                System.out.println("How much money do you have? ");
                double userMoney = reader.nextDouble();

                cardCreator user1 = new cardCreator(userName, userMoney);
                System.out.println("New card created!");
                System.out.println(user1);

                while (true) {
                    System.out.println("Available menus: \n" + userName + "'s card\nstore\ngo back");
                    
                    reader.nextLine();
                    String userMenu = reader.nextLine();
                    
                    
                    if (userMenu.startsWith(userName) || userMenu.endsWith("card")) {
                        System.out.println("The card menu works!");
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Thanks for using my program! Bye");
    }

}
