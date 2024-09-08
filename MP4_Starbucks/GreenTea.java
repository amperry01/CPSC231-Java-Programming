/** creates a green tea object
 * @author alyssa
 * @version 1.0
 * 
 * @see Order
 * @see Drink
 * @see Tea
 */
public class GreenTea extends Tea {
    /** private boolean to represent a matcha green tea if true */
    private boolean m_matcha;

    /** Default Constructor */
    public GreenTea() {
        m_size = "grande";
        m_base = "green tea";
        m_matcha = false;
    }

    /** Overloaded Constructor
     * @param s drink size
     * @param m true if drink is a matcha green tea, false otherwise
     */
    public GreenTea(String s, boolean m) {
        super(s, "green tea");
        m_matcha = m;
    }

    /** Accessor */
    public boolean getMatcha() {
        return m_matcha;
    }

    /** Mutator */
    public void setMatcha(boolean m) {
        m_matcha = m;
    }

    /** checks if both are matcha green teas or regular green teas 
     * @param o object to be compared to
     * @return true if both drinks are a matcha green tea, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GreenTea)) {
            return false;
        }
        GreenTea gT = (GreenTea) o;

        return m_matcha && gT.m_matcha;
    }

    /** abstract method implementation to calculate drink cost
     * @return cost of drink
     */
    public double calcCost() {
        m_cost = 0.0;

        if (m_size == "tall") {
            if (m_matcha) {
                m_cost = 4.95;
            }
            else {
                m_cost = 3.25;
            }
        }
        else if (m_size == "grande") {
            if (m_matcha) {
                m_cost = 5.25;
            }
            else {
                m_cost = 3.45;
            }
        }
        else if (m_size == "venti") {
            if (m_matcha) {
                m_cost = 5.75;
            }
            else {
                m_cost = 3.95;
            }
        }

        return m_cost;
    }

    /** toString method
     * @return parent class toString method, if drink is a matcha green tea, and cost
     */
    public String toString() {
        String s = super.toString();
        s += " matcha green tea? " + m_matcha + "\n";
        s += " cost: $" + calcCost();
        return s;
    }
}
