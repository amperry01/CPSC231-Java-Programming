/** holds americano coffee drinks
* @author rachel
* @version 1.1
* @see Coffee
* @see Drink
*/
public class Americano extends Coffee implements Comparable<Drink> {
    /** number of espresso shots */
    private int m_espressos;

    /** default constructor: grande hot americano */
    public Americano() {
      super();
      m_espressos = 3;
    }

    /** overloaded constructor */
    public Americano(String size, boolean ice, int espressos) {
      m_size = size;
      m_ice = ice;
      m_espressos = espressos;
      m_cost = this.calcCost();
    }

    /** copy constructor */
    public Americano(Americano a) {
      m_size = a.m_size;
      m_ice = a.m_ice;
      m_espressos = a.m_espressos;
      m_cost = a.m_cost;
    }

    /** size accessor */
    public String getSize() {
      return m_size;
    }

    /** price accessor */
    public double getPrice() {
      return m_cost;
    }

    /** ice accessor */
    public boolean getIce() {
      return m_ice;
    }

    /** espresso accessor */
    public int getEspressos() {
      return m_espressos;
    }

    /** size mutator */
    public void setSize(String size) {
      m_size = size;
    }

    /** ice mutator */
    public void setIce(boolean ice) {
      m_ice = ice;
    }

    /** espresso mutator */
    public void setEspressos(int espressos) {
      m_espressos = espressos;
    }

    /** calculates cost */
    public double calcCost() {
      if (m_size == "tall") {
        m_cost = 4.50;
      } else if (m_size == "grande") {
        m_cost = 4.75;
      } else {
        m_cost = 5.00;
      }
      return m_cost;
    }

    /** equals method */
    public boolean equals(Object obj){ 
      if(obj == this){ 
        return true;
      }
      if (!(obj instanceof Americano)){ 
        return false;
      } 
      Americano x = (Americano) obj; 
      return (this.m_size == x.m_size) & (this.m_ice == x.m_ice) & (this.m_espressos == x.m_espressos);
    }

    /** returns americano as a string */
    public String toString() {
      String s = m_size;
      if (m_ice == true) {
        s += " iced";
      }
      s += " americano with " + m_espressos + " espressos: $" + m_cost;
      return s;
    }

  }
  