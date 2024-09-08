/** holds latte coffee drinks 
* @author rachel
* @version 1.1
* @see coffee
*/
public class Latte extends Coffee implements Comparable<Drink> {
        /** type of milk */
    private String m_milk;

    /** default constructor: grande hot latte */
    public Latte() {
      super();
      m_milk = "whole";
    }

    /** overloaded constructor */
    public Latte(String size, boolean ice, String milk) {
      m_size = size;
      m_ice = ice;
      m_milk = milk;
      m_cost = this.calcCost();
    }

    /** copy constructor */
    public Latte(Latte l) {
      m_size = l.m_size;
      m_ice = l.m_ice;
      m_milk = l.m_milk;
      m_cost = l.m_cost;
    }

    /** size accessor */
    public String getSize() {
      return m_size;
    }

    /** price accessor */
    public double getCost() {
      return m_cost;
    }

    /** ice accessor */
    public boolean getIce() {
      return m_ice;
    }

    /** milk accessor */
    public String getMilk() {
      return m_milk;
    }

    /** size mutator */
    public void setSize(String size) {
      m_size = size;
    }

    /** ice mutator */
    public void setIce(boolean ice) {
      m_ice = ice;
    }

    /** milk mutator */
    public void setMilk(String milk) {
      m_milk = milk;
    }

    /** calculates cost */
    public double calcCost() {
      if (m_size == "tall") {
        m_cost = 5.70;
      } else if (m_size == "grande") {
        m_cost = 5.95;
      } else {
        m_cost = 6.20;
      }
      return m_cost;
    }

    /** equals method */
    public boolean equals(Object obj){ 
      if(obj == this){ 
        return true;
      }
      if (!(obj instanceof Latte)){ 
        return false;
      } 
      Latte x = (Latte) obj; 
      return (this.m_size == x.m_size) & (this.m_ice == x.m_ice) & (this.m_milk == x.m_milk);
    }

    /** returns latte as a string */
    public String toString() {
        String s = m_size + " " + m_milk + " milk";
        if (m_ice == true) {
        s += " iced";
        }
        s += " latte: $" + m_cost;
        return s;
    }
}
