import java.util.LinkedList;
import java.util.Random;

public class Player {
    /**
     * an integer to identify which player it is
     * */
    public int m_playerNum;

    /** a LinkedList of cards in a players hands
     * first element is the "top"
     * new cards should be added to the "bottom" (end of list)
     * cards in each hand will be 52 / number of players
     * */
    public LinkedList<Card> m_hand;

    /** a String for which pattern the player watches for
     * chosen at random from Game class's patterns array
     * doubles, sandwich, or topBottom
     */
    public String m_pattern;

    /** Overloaded Constructor
     * @param playerNum
     * @param hand
     * @param pattern
     */
    public Player(int playerNum, LinkedList<Card> hand, String pattern){
        m_playerNum = playerNum;
        m_hand = hand;
        m_pattern = pattern;
    }

    /** removes card from top of players hand
     * remove card at position 0
     * @return Card
     */
    public Card playCard(){
        // make sure hand is not empty
        if (!(m_hand.isEmpty())){
            Card c = m_hand.get(0);
            m_hand.remove(0);
            return c;
        }
        return null;
    }

    /** Checks for players assigned pattern
     * get player pattern
     * check for pattern
     * if pattern is in play @return true to slap
     * if not @return false
     */
    public boolean slaps(LinkedList<Card> pile){
        // check players pattern
        switch (m_pattern){
            case "doubles":
                return Game.doubles(Game.m_pile); // checks pile for pattern
            case "sandwich":
                return Game.sandwich(Game.m_pile);
            case "top bottom":
                return Game.topBottom(Game.m_pile);
            default:
                return false;
        }
    }

    /** 
     * Accessor Methods
     */
    public int getPlayerNum(){
        return m_playerNum;
    }

    public LinkedList<Card> getHand(){
        return m_hand;
    }

    public String getPattern(){
        return m_pattern;
    }

    /**
     * toString Method
     */
    @Override
    public String toString(){
        String s = "";
        s += "\nPlayer Number: " + m_playerNum;
        s += "\nHand: " + m_hand;
        s += "\nPattern: " + m_pattern + "\n";
        return s;
    }
}