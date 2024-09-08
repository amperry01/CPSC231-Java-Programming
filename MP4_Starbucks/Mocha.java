/** holds mocha coffee drinks 
* @author rachel
* @version 1.1
* @see coffee
*/
public class Mocha extends Coffee implements Comparable<Drink> {
    /** type of chocolate */
    private String m_chocolate;

    /** default constructor: grande hot mocha */
    public Mocha() {
      super();
      m_chocolate = "dark";
    }

    /** overloaded constructor */
    public Mocha(String size, boolean ice, String chocolate) {
      m_size = size;
      m_ice = ice;
      m_chocolate = chocolate;
      m_cost = this.calcCost();
    }

    /** copy constructor */
    public Mocha(Mocha m) {
      m_size = m.m_size;
      m_ice = m.m_ice;
      m_chocolate = m.m_chocolate;
      m_cost = m.m_cost;
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

    /** chocolate accessor */ 
    public String getChocolate() {
      return m_chocolate;
    }

    /** size mutator */
    public void setSize(String size) {
      m_size = size;
    }

    /** ice mutator */
    public void setIce(boolean ice) {
      m_ice = ice;
    }

    /** chocolate mutator */ 
    public void setChocolate(String chocolate) {
      m_chocolate = chocolate;
    }

    /** calculates cost */
    public double calcCost() {
      if (m_size == "tall") {
        m_cost = 6.20;
      } else if (m_size == "grande") {
        m_cost = 6.45;
      } else {
        m_cost = 6.70;
      }
      return m_cost;
    }

    /** equals method */
    public boolean equals(Object obj){ 
      if(obj == this){ 
        return true;
      }
      if (!(obj instanceof Mocha)){ 
        return false;
      } 
      Mocha x = (Mocha) obj; 
      return (this.m_size == x.m_size) & (this.m_ice == x.m_ice) & (this.m_chocolate == x.m_chocolate);
    }

    /** returns mocha as a string */
    public String toString() {
      String s = m_size + " " + m_chocolate + " chocolate";
      if (m_ice == true) {
        s += " iced";
      }
      s += " mocha: $" + m_cost;
      return s;
    }

  }