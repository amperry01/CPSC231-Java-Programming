/** creates a black tea object
 * @author alyssa
 * @version 1.0
 * 
 * @see Order
 * @see Drink
 * @see Tea
 */
public class BlackTea extends Tea {
    /** private boolean to represent a london fog if true */
    private boolean m_fog;
    
    /** Default Constructor */
    public BlackTea() {
        m_size = "grande";
        m_base = "black tea";
        m_fog = false;
    }

    /** Overloaded Constructor
     * @param s drink size
     * @param f true if london fog, false otherwise
     */
    public BlackTea(String s, boolean f) {
        super(s, "black tea");
        m_fog = f;
    }

    /** Accessor */
    public boolean getFog() {
        return m_fog;
    }

    /** Mutator */
    public void setFog(boolean f) {
        m_fog = f;
    }

    /** checks if both are london fogs or regular black teas 
     * @param o object to be compared to
     * @return true if both drinks are a london fog, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
		if (!(o instanceof BlackTea)) {
			return false;
		}
		BlackTea bT = (BlackTea) o;

		return m_fog && bT.m_fog;
    }

    /** abstract method implementation to calculate drink cost
     * @return cost of drink
     */
    public double calcCost() {
        m_cost = 0.0;

        if (m_size == "tall") {
            if (m_fog) {
                m_cost = 4.95;
            }
            else {
                m_cost = 3.25;
            }
        }
        else if (m_size == "grande") {
            if (m_fog) {
                m_cost = 5.25;
            }
            else {
                m_cost = 3.45;
            }
        }
        else if (m_size == "venti") {
            if (m_fog) {
                m_cost = 5.75;
            }
            else {
                m_cost = 3.95;
            }
        }

        return m_cost;
    }

    /** toString method
     * @return parent class toString method, if drink is a london fog, and cost
     */
    public String toString() {
        String s = super.toString();
        s += " london fog? " + m_fog + "\n";
        s += " cost: $" + calcCost(); 
        return s;
    }
}
