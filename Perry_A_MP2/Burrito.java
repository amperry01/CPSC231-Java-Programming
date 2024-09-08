/**
 * This is the Burrito class, it is used to represent a Burrito for CPSC-231
 * The Burrito class is related to the BurritoOrder class and the ChipotleDriver class.
 * @see Burrito
 * @see BurritoOrder
 * @see ChipotleDriver
 * 
 * @author Alyssa Perry
 * @version 1.0
 */

public class Burrito {
    /** A String attribute that represents the size of the burrito. Either kids or regular. */
    private String m_size;
    /** A String attribute that represents the protein type. Either chicken, steak, or veggie. */
    private String m_protein;
    /** A String attribute that represents the rice type. Either white, brown, or no rice. */
    private String m_rice;
    /** A String attribute that represents the type of beans. Either black, pinto, or no beans. */
    private String m_beans;
    /** A boolean attribute that represents if the burrito has guac or no guac. */
    private boolean m_guac;
    /** A boolean attribute that represents if the burrito has tomatillo or no tomatillo. */
    private boolean m_tomatillo;
    /** A boolean attribute that represents if the burrito has sour cream or no sour cream. */
    private boolean m_sourCream;
    /** A boolean attribute that represents if the burrito has cheese or no cheese. */
    private boolean m_cheese;
    /** A boolean attribute that represents if the burrito has lettuce or no lettuce. */
    private boolean m_lettuce;

    /** A double attribute that represensts the cost of the burrito
     * Static value because we only need to make changes to this value inside the burrito class,
     * the cost calculation does not need to be known by the ChipotleDriver class. Only the final cost.
     */
    public double burritoCost;

    /**
     * A default constructor for the burrito class.
     * Sets each member variable to a placeholder value.
     */
    public Burrito() {
        m_size = "regular";
        m_protein = "chicken";
        m_rice = "white";
        m_beans = "black";
        m_lettuce = true;
        m_sourCream = true;
    }

    /**
     * Fully specified constructor
     * An overloaded constructor for the burrito class.
     * Specifies each member variable as given.
     * @param size a string that will hold the value of the m_size attribute
     * @param protein a string that will hold the value of the m_protein attribute
     * @param rice a string that will hold the value of the m_rice attribute
     * @param beans a string that will hold the value of the m_beans attribute
     * @param guac a boolean that will hold the value of the m_guac attribute
     * @param tomatillo a boolean that will hold the value of the m_tomatillo attribute
     * @param sourCream a boolean that will hold the value of the m_sourCream attribute
     * @param cheese a boolean that will hold the value of the m_cheese attribute
     * @param lettuce a boolean that will hold the value of the m_lettuce attribute
     */
    public Burrito(String size, String protein, String rice, String beans, boolean guac, boolean tomatillo, boolean sourCream, boolean cheese, boolean lettuce) {
        m_size = size;
        m_protein = protein;
        m_rice = rice;
        m_beans = beans;
        m_guac = guac;
        m_tomatillo = tomatillo;
        m_sourCream = sourCream;
        m_cheese = cheese;
        m_lettuce = lettuce;
    }

    /**
     * Copy constructor
     * Creates a copy of a pre-existing burrito
     * @param burritoToCopy the pre-existing burrito you want to replicate
     */
    public Burrito(Burrito burritoToCopy) {
        m_size = burritoToCopy.m_size;
        m_protein = burritoToCopy.m_protein;
        m_rice = burritoToCopy.m_rice;
        m_beans = burritoToCopy.m_beans;
        m_guac = burritoToCopy.m_guac;
        m_tomatillo = burritoToCopy.m_tomatillo;
        m_sourCream = burritoToCopy.m_sourCream;
        m_cheese = burritoToCopy.m_cheese;
        m_lettuce = burritoToCopy.m_lettuce;
    }

    // MUTATORS AND ACCESSORS

    /** 
     * To get access to the burrito's size 
     * @return burrito size
     */
    public String getSize() {
        return m_size;
    }

    /**
     * A mutator that sets the burrito size
     * @param size a string that will hold the value of the m_size attribute
     */
    public void setSize(String size) {
        m_size = size;
    }

    /** 
     * To get access to the burrito's protein type 
     * @return protein type
     */
    public String getProtein() {
        return m_protein;
    }

    /**
     * A mutator that sets the burrito's protein type
     * @param protein a string that will hold the value of the m_protein attribute
     */
    public void setProtein(String protein) {
        m_protein = protein;
    }

    /**
     * To get access to the burrito's rice type
     * @return rice type
     */
    public String getRice() {
        return m_rice;
    }

    /**
     * A mutator that sets the burrito rice type
     * @param rice a string that will hold the value of the m_rice attribute
     */
    public void setRice(String rice) {
        m_rice = rice;
    }

    /**
     * To get access to the burrito's beans type
     * @return beans type
     */
    public String getBeans() {
        return m_beans;
    }

    /**
     * A mutator that sets the burrito beans type
     * @param beans a string that will hold the value of the m_beans attribute
     */
    public void setBeans(String beans) {
        m_beans = beans;
    }

    /**
     * To get access to if the burrito has guac or not
     * @return guac or no guac
     */
    public boolean getGuac() {
        return m_guac;
    }

    /**
     * A mutator that sets if the burrito has guac or not
     * @param guac a boolean that will hold the value of the m_guac attribute
     */
    public void setGuac(boolean guac) {
        m_guac = guac;
    }

    /**
     * To get access to if the burrito has tomatillo or not
     * @return tomatillo or no tomatillo
     */
    public boolean getTomatillo() {
        return m_tomatillo;
    }

    /**
     * A mutator that sets if the burrito has tomatillo or not
     * @param tomatillo a boolean that will hold the value of the m_tomatillo attribute
     */
    public void setTomatillo(boolean tomatillo) {
        m_tomatillo = tomatillo;
    }

    /**
     * To get access to if the burrito has sour cream or not
     * @return sour cream or no sour cream
     */
    public boolean getSourCream() {
        return m_sourCream;
    }

    /**
     * A mutator that sets if the burrito has sour cream or not
     * @param sourCream a boolean that will hold the value of the m_sourCream attribute
     */
    public void setSourCream(boolean sourCream) {
        m_sourCream = sourCream;
    }

    /**
     * To get access to if the burrito has cheese or not
     * @return cheese or no cheese
     */
    public boolean getCheese() {
        return m_cheese;
    }
    
    /**
     * A mutator that sets if the burrito has cheese or not
     * @param cheese a boolean that will hold the value of the m_cheese attribute
     */
    public void setCheese(boolean cheese) {
        m_cheese = cheese;
    }

    /**
     * To get access to if the burrito has lettuce or not
     * @return lettuce or no lettuce
     */
    public boolean getLettuce() {
        return m_lettuce;
    }

    /**
     * A mutator that sets if the burrito has lettuce or not
     * @param lettuce a boolean that will hold the value of the m_lettuce attribute
     */
    public void setLettuce(boolean lettuce) {
        m_lettuce = lettuce;
    }

    /**
     * A method calculate the cost of a burrito based on each of its member variables
     * @return the total cost of the burrito
     */
    public double calcCost() {
        burritoCost = 0; // initialize burrito cost for each variable

        if (m_size == "kids"){
            burritoCost += 7.00;
        }
        else if (m_size == "regular"){
            burritoCost += 9.00;
        }

        if (m_protein == "chicken"){
            burritoCost += 0.50;
        }
        else if (m_protein == "steak"){
            burritoCost += 1.25;
        }
        else if (m_protein == "veggie"){
            burritoCost += 0.50;
        }

        if (m_protein != "veggie" && m_guac == true){
            burritoCost += 2.65;
        }
        
        if (m_sourCream == true){
            burritoCost += 0.25;
        }

        if (m_cheese == true){
            burritoCost += 0.50;
        }

        return burritoCost;
    }

    /**
     * A method to print a burrito's member variables
     * @return a string containing each member variable and the cost of the burrito
     */
    public String toString() {
        String s = "";
        s += "Size: " + m_size;
        s += "\nProtein: " + m_protein;
        s += "\nRice: " + m_rice;
        s += "\nBeans: " + m_beans;
        s += "\nGuacamole: " + m_guac;
        s += "\nTomatillo Salsa: " + m_tomatillo;
        s += "\nSour Cream: " + m_sourCream;
        s += "\nCheese: " + m_cheese;
        s += "\nLettuce: " + m_lettuce;
        s += "\nCost: " + calcCost();

        return s;
    }

    /**
     * A method that determines if two burritos are equal
     * @param o an object that represents the burrito we want to compare to the burrito it was referenced with
     * @return a boolean stating true if the burritos are the same and false if the burritos are not the same
     */
    public boolean equals(Object o) {
        
        // check memory location first
        if (o == this){
            return true;
        }

        // check if o is an instance of Burrito class
        if (!(o instanceof Burrito)){
            return false;
        }

        // if we get here, o is a Burrito
        Burrito b = (Burrito) o;

        // check member variables
        boolean isBurritoEqual = false;
        if (this.m_size == b.m_size){ if (this.m_protein == b.m_protein){
                if (this.m_rice == b.m_rice){ if (this.m_beans == b.m_beans){
                        if (this.m_guac == b.m_guac){ if (this.m_tomatillo == b.m_tomatillo){
                                if (this.m_sourCream == b.m_sourCream){ if (this.m_cheese == b.m_cheese){
                                        if (this.m_lettuce == b.m_lettuce){
                                            isBurritoEqual = true; }}}}}}}}
        } else { isBurritoEqual = false; }

        return isBurritoEqual;
    }
}