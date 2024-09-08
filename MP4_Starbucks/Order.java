/** holds all drinks in an order 
 * @author rachel, alyssa
 * @version 1.1
 *
 * @see Drink
 * @see Coffee
 * @see Tea
 * @see Latte
 * @see Mocha
 * @see Americano
 * @see Chai
 * @see GreenTea
 * @see BlackTea
 */

import java.util.LinkedList;

public class Order {
    /** private member variable for customers name */
    private String m_name;
    /** private LinkedList of type Drink to hold all drinks in an order */
    private LinkedList<Drink> m_order;

    /** default constructor: empty order */
    public Order() {
        m_name = "no name";
        m_order = new LinkedList<Drink>();
    }

    /** Fully specified constructor 
     * @param name customers name
     */
    public Order(String name) {
        m_name = name;
        m_order = new LinkedList<Drink>();
    }

    /** method to add a drink to the order list
     * @param d drink to be added
     */
    public void addDrink(Drink d) {
        m_order.add(d);
    }

    /** method to get a drink from the order list
     * @param i index of drink to be accessed
     * @return drink at given index
     */
    public Drink getDrink(int i) {
        return m_order.get(i);
    }

    /** method to calculate the total cost of an order 
     * @return total order cost
     */
    public double calcTotal() {
        double drinkCost;
        double totalCost = 0.0;

        for (int i = 0; i < m_order.size(); ++i) {
            drinkCost = m_order.get(i).calcCost();
            totalCost += drinkCost;
        }

        return totalCost;
    }

    /** toString method 
     * @return a string with customer name, order total, and drinks in order
     */
    public String toString() {
        String s = "";
        s += "-------------------- \n";
        s += "name: " + m_name + "\n";
        s += "total cost: $" + calcTotal() + "\n";
        for (int i = 0; i < m_order.size(); ++i){
            s += "drink " + (i + 1) + ": " + "\n" + m_order.get(i) + "\n";
        }
        return s;
    }
}
