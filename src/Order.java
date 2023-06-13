import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

        // Create double variable, subtotal and initialize it
        double subtotal = 0.0;

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
                order.add(drinkMenu.get(0));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("Item successfully added to order");
            } else if (orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("Item successfully added to order");
            }  else {
                System.out.println("Sorry, we don't seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            String continueOrder = scan.nextLine();
            // if statement that checks if placeOrder does NOT equal Y
            if (!continueOrder.equalsIgnoreCase("y")) {
                ordering = false;
            }
        }

        // Print out first and second item in the order ArrayList
        System.out.println(order.get(0));
        System.out.println(order.get(1));

        for (int i = 2; i< order.size(); i++){
            // Check if order at i is equal to cupcakeMenu at 0
            if (order.get(i).equals(cupcakeMenu.get(0))){
                // Print the type of cupcake at cupcakeMenu index 0
                cupcakeMenu.get(0).type();
                // Print the price of cupcake at cupcakeMenu index 0
                System.out.println(cupcakeMenu.get(0).getPrice());
                //Set subtotal equal to subtotal plus cupcakeMenu getPrice at 0
                subtotal += cupcakeMenu.get(0).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(1))){
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).getPrice());
                subtotal += cupcakeMenu.get(1).getPrice();
            }else if (order.get(i).equals(cupcakeMenu.get(2))){
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).getPrice());
                subtotal += cupcakeMenu.get(2).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(0))){
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).getPrice());
                subtotal += drinkMenu.get(0).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(1))){
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).getPrice());
                subtotal += drinkMenu.get(1).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(2))){
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).getPrice());
                subtotal += drinkMenu.get(2).getPrice();
            }
        }
        // Print The subtotal
        System.out.println("Subtotal: $"+subtotal);
        System.out.println("Total: $"+ Math.round(subtotal*(1+.065)*100.0)/100.0 + " (6.5% tax included)");

        //Create a new CreateFile()
        new CreateFile();
        // Create a new WriteToFile() with param order
        new WriteToFile(order);
    }
}

class CreateFile{
    public CreateFile(){
        // Create a try catch block, with a catch parameter of IOException e
        try {
            //  create File object named salesData and set it equal to a new File object with the name “salesData.txt”
            File salesData = new File("salesData.txt");
            // Create if statement with param salesData.createNewFile()
            // .createNewFile() will return true if a new file is created
            if (salesData.createNewFile()){
                System.out.println("File created: " + salesData.getName());
            } else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("An Error occurred! --> " + e);
        }
    }
}

class WriteToFile{
    public WriteToFile(ArrayList<Object> order){
        // Create a try catch block, with a catch parameter of IOException e
        try{
            // Create a new FileWriter object named fw = new FileWriter with
            // parameter object "salesData.txt", and the boolean true (an option that
            // allows for appending to the file)
            FileWriter fw = new FileWriter("salesData.txt", true);
            //Create a new PrintWriter object, salesWriter = new PrintWriter object whose
            // constructor parameter is the FileWriter object fw created previously
            PrintWriter salesWriter = new PrintWriter(fw);
            // Print each value in the Object instance, order
            for (int i=0; i< order.size(); i++){
                salesWriter.println(order.get(i));
            }
            // Add line and LineSpace between the printWriting
            salesWriter.println("-".repeat(30)+"\n");
            // Stop the writer from continuing to run
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e){
            System.out.println("An error occurred!");
        }
    }
}
