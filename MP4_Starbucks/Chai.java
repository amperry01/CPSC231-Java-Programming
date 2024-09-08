/** creates a chai tea object
 * @author alyssa
 * @version 1.0
 * 
 * @see Order
 * @see Drink
 * @see Tea
 */
public class Chai extends Tea {
    /** private boolean to represent a chai tea latte if true */
    private boolean m_latte;
    
    /** Default Constructor */
    public Chai() {
        m_size = "grande";
        m_base = "chai";
        m_latte = false;
    }

    /** Overloaded Constructor
     * @param s string for drink size
     * @param l boolean for chai tea latte
     */
    public Chai(String s, boolean l) {
        super(s, "chai");
        m_latte = l;
    }

    /** Accessor */
    public boolean getLatte() {
        return m_latte;
    }

    /** Mutator */
    public void setLatte(boolean l) {
        m_latte = l;
    }

    /** checks if both are chai tea lattes or regular chai teas 
     * @param o object to be compared to
     * @return true if both objects are chai tea lattes, false if not
     */
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
		if (!(o instanceof Chai)) {
			return false;
		}
		Chai c = (Chai) o;

		return m_latte && c.m_latte;
    }

    /** abstract method implementation to calculate drink cost
     * @return cost of drink
     */
    public double calcCost() {
        m_cost = 0.0;

        if (m_size == "tall") {
            if (m_latte) {
                m_cost = 4.95;
            }
            else {
                m_cost = 3.25;
            }
        }
        else if (m_size == "grande") {
            if (m_latte) {
                m_cost = 5.25;
            }
            else {
                m_cost = 3.45;
            }
        }
        else if (m_size == "venti") {
            if (m_latte) {
                m_cost = 5.75;
            }
            else {
                m_cost = 3.95;
            }
        }

        return m_cost;
    }

    /** toString method
     * @return parent class toString method, if drink is a chai tea latte, and cost
     */
    public String toString() {
        String s = super.toString();
        s += " chai latte? " + m_latte + "\n";
        s += " cost: $" + calcCost(); 
        return s;
    }

}
