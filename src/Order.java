import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake>cupcakeMenu, ArrayList<Drink>drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        // Create a Scanner object
        Scanner scan = new Scanner(System.in);
        // Assign the input to String variable, placeOrder
        String placeOrder = scan.nextLine() ;

        // Create an Arraylist of Objects and name it order
        ArrayList <Object> order = new ArrayList<Object>();

        // Create boolean variable, ordering and Initialize it to true
        boolean ordering = true;

        if (placeOrder.equalsIgnoreCase("y")){
            // Add localDate.now()
            order.add(LocalDate.now());
            // Add localTime.now()
            order.add(LocalTime.now());

            System.out.println("Here is the menu");
            System.out.println("CUPCAKES: ");

            // Create int variable, itemNumber and initialize it to 0
            int itemNumber = 0;
            for (int i=0; i<cupcakeMenu.size(); i++){
                itemNumber++;
                System.out.println(itemNumber);

                //  Print a description of the cupcake at cupcakeMenu at index i
                cupcakeMenu.get(i).type();

                System.out.println("Price: $"+ cupcakeMenu.get(i).getPrice());

                // Print a dashed line
                System.out.println("-".repeat(45));
            }

            System.out.println("DRINKS: ");
            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);

                // Output the type of drink at drinkMenu at i by calling the type()
                drinkMenu.get(i).type();

                System.out.println("Price: $" + drinkMenu.get(i).getPrice());

                // Print a dashed line
                System.out.println("-".repeat(45));
            }

        } else{
            System.out.println("Have a nice day then.");
        }

        while (ordering){
            // Ask user for order of choice
            System.out.println("What would you like to order? Please use the number associated with each item to order.");

            // Create int variable named orderChoice
            int orderChoice = scan.nextInt();
            // Call scan.nextLine() to correct the terminal scanner input location
            scan.nextLine();

            if (orderChoice == 1){
                order.add(cupcakeMenu.get(0));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 4) {
                order.add(cupcakeMenu.get(3));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 5) {
                order.add(cupcakeMenu.get(4));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 6) {
                order.add(cupcakeMenu.get(5));
                System.out.println("Item successfully added to order");
            }  else {
                System.out.println("Sorry, we don't seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            placeOrder = scan.nextLine();
            // if statement that checks if placeOrder does NOT equal Y
            if (!placeOrder.equalsIgnoreCase("y")) {
                ordering = false;
            }
        }
    }
}
