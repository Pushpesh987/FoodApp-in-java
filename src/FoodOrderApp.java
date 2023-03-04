import java.util.ArrayList;
import java.util.Scanner;

//import static java.lang.Shutdown.exit;

public class FoodOrderApp {

    // Define the food items available in the food court
    private static String[] foodItems = {"Burger", "Pizza", "Sandwich", "French Fries", "Soda"};

    // Define the prices of the food items
    private static double[] foodPrices = {10.00, 12.50, 8.00, 5.00, 2.00};

    // Define an ArrayList to store the orders
    private static ArrayList<String> orderList = new ArrayList<String>();

    // Define a Scanner object to read user input
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("-------MENU----------");
            System.out.println("\n1.Menu\n2.Bill\n3.Exit");
            System.out.println("\nEnter your choice:");
            choice = input.nextInt();
            switch (choice) {

                case 1:
                    // Print the food menu
                    System.out.println("Welcome to the food court! Here is our menu:");
                    for (int i = 0; i < foodItems.length; i++) {
                        System.out.println((i + 1) + ". " + foodItems[i] + " - $" + foodPrices[i]);
                    }

                    // Prompt the user to place an order
                    System.out.println("Please enter the number of the food item you would like to order (or enter 0 to exit):");
                    int orderNumber = input.nextInt();

                    // Loop to process the user's orders
                    while (orderNumber != 0) {

                        // Check if the order number is valid
                        if (orderNumber < 0 || orderNumber > foodItems.length) {
                            System.out.println("Invalid order number. Please try again.");
                        } else {
                            // Add the item to the order list
                            orderList.add(foodItems[orderNumber - 1]);
                            System.out.println(foodItems[orderNumber - 1] + " has been added to your order.");
                        }

                        // Prompt the user to place another order or exit
                        System.out.println("Please select the food item you would like to order (or enter 0 to exit):");
                        orderNumber = input.nextInt();

                    }
                    break;
                case 2:
                    // Print the order summary
                    System.out.println("Thank you for your order! Here is your bill:");
                    double totalCost = 0;
                    for (String item : orderList) {
                        int index = java.util.Arrays.asList(foodItems).indexOf(item);
                        totalCost += foodPrices[index];
                        System.out.println(item + " - $" + foodPrices[index]);
                    }
                    System.out.println("Total cost: $" + totalCost);
                    break;

                case 3:System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }while(choice>=1&&choice<=2);
    }
}