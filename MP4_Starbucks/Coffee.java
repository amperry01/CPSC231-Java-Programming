/** holds all coffee drinks
* @author Rachel
* @version 1.1
* @see Drink
*/
public class Coffee extends Drink implements Comparable<Drink> {
    /** coffee drink base */
    protected static String m_base = "coffee";
    /** if the drink has ice */
    protected boolean m_ice;

    /** default constructor: black coffee */
    public Coffee() {
      m_size = "grande";
      m_ice = false;
      m_cost = this.calcCost();
    }

    /** overloaded constructor */
    public Coffee(String size, boolean ice) {
      m_size = size;
      m_ice = ice;
      m_cost = this.calcCost();
    }

    /** copy constructor  */ 
    public Coffee(Coffee c) {
      m_size = c.m_size;
      m_ice = c.m_ice;
      m_cost = c.m_cost;
    }

    /** size accessor */
    public String getSize() {
      return m_size;
    }

    /** ice accessor */
    public boolean getIce() {
      return m_ice;
    }

    /** size mutator */
    public void setSize(String size) {
      m_size = size;
    }

    /** ice mutator */
    public void setIce(boolean ice) {
      m_ice = ice;
    }

    /** calculates cost */
    public double calcCost() {
      if (m_size == "tall") {
        m_cost = 3.50;
      } else if (m_size == "grande") {
        m_cost = 3.75;
      } else {
        m_cost = 4.00;
      }
      return m_cost;
    }

    /** returns coffee as a string */
    public String toString() {
      String s = m_size;
      if (m_ice == true) {
        s += " iced";
      }
      s += " coffee: $" + m_cost;
      return s;
    }

    /** equals method */
    public boolean equals(Object obj){ 
      if(obj == this){ 
        return true;
      }
      if (!(obj instanceof Coffee)){ 
        return false;
      } 
      Coffee x = (Coffee) obj; 
      return (this.m_size == x.m_size) & (this.m_ice == x.m_ice);
    }
  }
