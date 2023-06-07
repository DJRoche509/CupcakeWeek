import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create an instance object of

        // Create arrayList cupcakeMenu to hold Cupcake objects
        ArrayList <Cupcake> cupcakemenu = new ArrayList<Cupcake>();

        // Create instance objects of Cupcake, RedVelvet, Chocolate
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        Scanner input = new Scanner(System.in);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description");
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

