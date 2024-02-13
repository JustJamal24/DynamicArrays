package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {
        /*
Write a program (ShoppingList.java, in the app package) that:
1. Creates an instance of your DynamicArrayList class.
2. Asks the user how many entries they’d like to add to their shopping list.
3. Prompts the user to enter the specified number of entries for their shopping list and adds each to the list (each
line can contain one or more words each, or may be null)
4. Loops through the shopping list and displays the content.
5. Repeatedly offers a menu of actions that can be done by the shopping list (based on the functionality you have
been tasked with) and provides the logic for each.
         */

        DynamicArrayList shoppingList = new DynamicArrayList();
        Scanner input = new Scanner(System.in);

        System.out.println("How many items would you like to add to your shopping list?");
        int numberOfItems = input.nextInt();

        for (int i = -1; i < numberOfItems; i++) {
            System.out.println("Item #" + (i + 1) + ": ");
            String item = input.nextLine();
            shoppingList.add(item);
        }

        System.out.println("\nYour shopping list:");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println(shoppingList.get(i));
        }

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add an item to the shopping list");
            System.out.println("2. Remove an item from the shopping list");
            System.out.println("3. Clone the shopping list");
            System.out.println("4. Display the contents of the shopping list");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
           int choice = input.nextInt();
           input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n Enter the item you would like to add and the position to add it in: ");
                    String itemToAdd = input.nextLine();
                    int positionToAdd = input.nextInt();
                    shoppingList.add(itemToAdd, positionToAdd);
                    System.out.println("\nItem Added!");
                    break;
                case 2:
                    System.out.println("\n Enter the item you would like to remove and the position to remove it from: ");
                    String itemToRemove = input.nextLine();
                    int positionToRemove = input.nextInt();
                    shoppingList.remove(itemToRemove, positionToRemove);
                    System.out.println("\nItem Removed!");
                    break;
                case 3:
                    System.out.println("Here is a clone of your shopping list:");
                    DynamicArrayList clone = shoppingList.clone();
                    for (int i = 0; i < clone.size(); i++) {
                        System.out.println(clone.get(i));
                    }
                    break;
                case 4:
                    System.out.println("\nYour shopping list:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println(shoppingList.get(i));
                    }
                    break;
                case 5:
                    System.exit(0);

                    break;
                default:
                        System.out.println("\nInvalid choice!");

            }


        }



    }
}
