/** takes an order and prints the reciept 
 * @author rachel, alyssa
 * @version 1.1
 * @see Order 
 * @see Coffee
 * @see Tea
 * @see Latte
 * @see Mocha
 * @see Americano
 * @see Chai
 * @see GreenTea
 * @see BlackTea
 */

import java.io.*;

public class Barista {
    public static void main(String[] args) {
        Order o = new Order("joe");
        o.addDrink(new Chai());
        o.addDrink(new Chai("venti", true));
        o.addDrink(new BlackTea());
        o.addDrink(new GreenTea("tall", false));
        o.addDrink(new Coffee("venti", false));
        o.addDrink(new Americano("tall", false, 2));
        o.addDrink(new Mocha("grande", true, "white"));
        o.addDrink(new Latte("venti", true, "whole"));
        System.out.println(o);
        System.out.println(o.getDrink(0).compareTo(o.getDrink(1)));

        /**
         * Outputting order details to a file called "receipt"
         */
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("receipt.txt"));
            pw.println(o);
            pw.close();
        } 
        catch (IOException ioe) {
            System.err.println("couldn't output to file!");
            ioe.printStackTrace();
        }
  }
}
