/** creates a drink object
 * @author alyssa
 * @version 1.1
 * 
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

public abstract class Drink implements Comparable<Drink> {
    /** protected String for the size of the drink */
    protected String m_size;
    /** protected String for the base of each drink */
    protected String m_base;
    /** protected double for the cost of each drink */
    protected double m_cost;

    /** Default Construstor */
    public Drink() {
        m_size = "grande";
        m_base = null;
    }

    /** Fully Specified Constructor
     * @param s String for the size of drink
     * @param b String for the base of drink
     */
    public Drink(String s, String b) {
        m_size = s;
        m_base = b;
    }

    /** Copy Constructor 
     * @param d for the Drink to be copied
     */
    public Drink(Drink d) {
        this.m_size = d.m_size;
        this.m_base = d.m_base;
    }

    /** Accessors */
    public String getSize() {
        return m_size;
    }

    public String getBase() {
        return m_base;
    }

    /** Mutators */
    public void setSize(String s) {
        m_size = s;
    }

    public void setBase(String b) {
        m_base = b;
    }

    /** toString Method 
     * @return drink size and base
    */
    public String toString() {
        String s = "";
        s += " size: " + m_size + "\n";
        s += " base: " + m_base + "\n";
        return s;
    }

    /** Equals Method 
     * compares Drinks based on size and base
     * @param o the object to be compared to
     * @return true if drinks are the same size and base, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Drink)) {
            return false;
        }
        Drink d = (Drink) o;

        return m_size.equals(d.m_size) && m_base.equals(d.m_base);
    }

    /** Abstract Method 
     * will be used in each child class to calculate the cost of each drink
     * @return cost of each drink
     */
    public abstract double calcCost();

    /** Comparable Implementation 
     * @param d Drink to be compared based on cost
     * @return 1, -1, or 0 depending on which drink costs the most or if the drinks are the same price
     */
    public int compareTo(Drink d) {
        int ret;
        if (this.calcCost() > d.calcCost()) {
            ret = 1;
        }
        else if (this.calcCost() < d.calcCost()) {
            ret = -1;
        }
        else {
            ret = 0;
        }
        return ret;
    }

}
