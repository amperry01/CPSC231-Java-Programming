/** Tea parent class, creates a tea object
 * @author alyssa
 * @version 1.1
 * 
 * @see Order
 * @see Drink
 * @see Chai
 * @see GreenTea
 * @see BlackTea
 */

public abstract class Tea extends Drink {

    /** Default Constructor */
    public Tea() {
        super();
    }

    /** Overloaded Constructor
     * @param s size of the drink
     * @param b base of the drink
     */
    public Tea(String s, String b) {
        super(s, b);
    }

    /** toString method
     * @return size and base of tea
     */
    public String toString() {
        String s = super.toString();
        return s;
    }
}
