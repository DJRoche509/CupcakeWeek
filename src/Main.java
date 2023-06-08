import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create an instance object of

        // Create arrayList cupcakeMenu to hold Cupcake objects
        ArrayList <Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        // Create instance objects of Cupcake, RedVelvet, Chocolate
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");

        // Invoke cupcake.type()
        cupcake.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        // Get user's input for price to be charged
        String priceText = input.nextLine();
        // Convert priceText to the double variable, price
        double price = Double.parseDouble(priceText);
        // Invoke cupcake instance object to set the price by passing "price" as parameter
        cupcake.setPrice(price) ;


        /*   redVelvet   */
       System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");

        // Invoke cupcake.type()
        redVelvet.type();

        System.out.println("How much would you like to charge for the red velvet cupcake? \n(Input a numerical number taken to 2 decimal places)");
        // Get user's input for price to be charged
        priceText = input.nextLine();
        // Convert priceText to the double variable, price
        price = Double.parseDouble(priceText);
        // Set price for the redVelvet cupcake
        redVelvet.setPrice(price) ;


        /*   chocolate  */
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");

        // Invoke cupcake.type()
        chocolate.type();

        System.out.println("How much would you like to charge for the chocolate cupcake? \n(Input a numerical number taken to 2 decimal places)");
        // Get user's input for price to be charged
       priceText = input.nextLine();
        // Convert priceText to the double variable, price
        price = Double.parseDouble(priceText);
        // Set price for the chocolate cupcake
        chocolate.setPrice(price) ;

        // Add each cupcake object to the cupcakeMenu arrayList
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);
    }
}

class Cupcake{
    public double price ;

    /**
     * {double} - The getPrice function
     * @return @price returns a double
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake{
    public void type(){
        System.out.println("A red velvet based cupcake, with cream cheese frosting");
    }
}

class Chocolate extends Cupcake{
    public void type(){
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

