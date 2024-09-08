/**
 * This is the BurritoOrder class, it is used to represent an order of burritos for CPSC-231
 * The BurritoOrder class is related to the Burrito class and ChipotleDriver class.
 * @see Burrito
 * @see BurritoOrder
 * @see ChipotleDriver
 * 
 * @author Alyssa Perry
 * @version 1.0
 */

public class BurritoOrder {
    /** An array attribute that represents an order of one or mutliple burritos. */
    private Burrito[] m_order;
    /** An int attribute that represnets the number of burritos currently in m_order */
    private int m_numBurritos;
    /** An int attribute that represents the max number of burritos that will be in an order (size of m_order) */
    private int m_numBurritosMax;

    /**
     * A default constructor for the BurritoOrder class.
     * Defaults to the order of a single default Burrito.
     */
    public BurritoOrder() {
        m_numBurritosMax = 1;
        m_order = new Burrito[m_numBurritosMax];
    }

    /**
     * An overloaded constructor for the BurritoOrder class.
     * Creates an order array with a specified size from the given parameter
     * @param numBurritosMax an int that specifies the number of burritos in the order
     */
    public BurritoOrder(int numBurritosMax) {
        m_numBurritosMax = numBurritosMax;
        m_order = new Burrito[m_numBurritosMax];
    }

    /**
     * A method to add a burrito object to the burrito order array.
     * @param b
     * @return an int representing if adding the burrito was successful (1) or not succesful (-1)
     */
    public int addBurrito(Burrito b) {
        // an integer that represents if the burrito has been added or not
        int checkAdd = -1;
        for (int i = 0; i < m_order.length; i++){
            if (m_order[i] == null){
                m_order[i] = b;
                checkAdd = 1;
                break;
            }
            else {
                checkAdd = -1;
            }
        }
        return checkAdd;
    }

    /**
     * A method that returns the total order cost after adding up the cost of each burrito in the order.
     * @return the total cost of order
     */
    public double calcTotal() {
        // a double to temporarily store burrito cost
        double burritoCost;

        // a double to store total cost
        double totalCost = 0;

        for (int i = 0; i < m_order.length; i++){
            burritoCost = m_order[i].calcCost();
            totalCost += burritoCost;
        }

        return totalCost;
    }

    /**
     * A method that returns a string so that the employee can repeat the order back to customer.
     * @return a string containing total cost, each burrito, and the details of each burrito.
     */
    public String toString() {
        String s = "";
        s += "Total Cost: " + calcTotal() + "\n";
        for (int i = 0; i < m_order.length; i++){
            s += "\nBurrito " + (i+1) + ":\n" + m_order[i] + "\n"; 
        }

        return s;
    }

}