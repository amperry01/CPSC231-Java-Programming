/**
 * This is the ChipotleDriver class, it is used to represent a chipotle ordering system for CPSC-231
 * The ChipotleDriver class is related to the Burrito class and BurritoOrder class.
 * @see Burrito
 * @see BurritoOrder
 * @see ChipotleDriver
 * 
 * @author Alyssa Perry
 * @version 1.0
 */

// ChipotleDriver class declaration
public class ChipotleDriver {
    // main method declaration 
    /** Main method, instantiates instances of Burrito and BurritoOrder */
    public static void main(String[] args){ 

        // fill in the blank spots below:
        /** Burrito 1: Creates a default burrtio */
        Burrito defaultBurrito = new Burrito(); 

        // veggieBurrito: regular, veggie, white rice, pinto beans, guacamole, lettuce, tomatillo 
        /** Burrito 2: Creates a veggie burrito */
        Burrito veggieBurrito = new Burrito("regular", "veggie", "white", "pinto", true, true, false, false, true);

        /** Burrito 3: Creates a new veggie burrito as a deep copy of the first veggie burrito */
        Burrito veggieBurrito2 = new Burrito(veggieBurrito);

        /** Burrito 4: Creates a new default burrito as a deep copy of the first default burrito */
        Burrito  defaultBurrito2 = new Burrito(defaultBurrito);

        /** Creates a new order of 3 burritos */
        BurritoOrder order = new BurritoOrder(3);


        // no need to change anything here

        // add defaultBurrito to the order
        System.out.println(order.addBurrito(defaultBurrito));

        // add veggieBurrito to the order
        System.out.println(order.addBurrito(veggieBurrito));

        // add veggieBurrito2 to the order
        System.out.println(order.addBurrito(veggieBurrito2));

        // add defaultBurrito2 to the order – what happens here?
            // returns -1 as the length of the order is being exceeded
        System.out.println(order.addBurrito(defaultBurrito2));

        // are veggieBurrito and veggieBurrito2 the same? should be!
        System.out.print("are veggieBurrito and veggieBurrito2 the same? ");
        System.out.println(veggieBurrito.equals(veggieBurrito2));
        // are veggieBurrito and defaultBurrito the same? shouldn't be...
        System.out.print("are veggieBurrito and defaultBurrito the same? ");
        System.out.println(veggieBurrito.equals(defaultBurrito));

        // Should call order’s toString methods
        System.out.println(order);
    }
}