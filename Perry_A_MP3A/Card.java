public class Card {
    // member varibles for rank and suit
    public int m_rank; // 2-10, J, Q, K, A
    public int m_suit; // hearts, spades, clubs, diamonds

    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // default constructor, ace of spades
    public Card(){
        m_rank = ACE;
        m_suit = SPADES;
    }
    
    // overloaded constructor
    public Card(int rank, int suit){
        m_rank = rank;
        m_suit = suit;
    }

    // copy constructor
    public Card(Card cardToCopy){
        m_rank = cardToCopy.m_rank;
        m_suit = cardToCopy.m_suit;
    }

    // toString method
    public String toString(){
        String s = "";

        if (m_rank == ACE){
            s += "Ace";
        } else if (m_rank == JACK){
            s += "Jack";
        } else if (m_rank == QUEEN){
            s += "Queen";
        } else if (m_rank == KING){
            s += "King";
        } else {
            s += m_rank;
        }

        s += " of ";

        if (m_suit == HEARTS){
            s += "Hearts";
        } else if (m_suit == SPADES){
            s += "Spades";
        } else if (m_suit == CLUBS){
            s += "Clubs";
        } else if (m_suit == DIAMONDS){
            s += "Diamonds";
        }

        return s;
    }

    // equals method, cards are equal if their ranks are equal
    public boolean equals(Object o){
        // check memory location
        if (o == this){
            return true;
        }

        // check if a card object
        if (!(o instanceof Card)){
            return false;
        }

        // type cast o back into a card
        Card c = (Card) o;
        
        // check if rank is equal
        if (c.m_rank == this.m_rank){
            return true;
        } else {
            return false;
        }
    }

    public void setRank(int rank){
        m_rank = rank;
    }

    public int getRank(){
        return m_rank;
    }

    public void setSuit(int suit){
        m_suit = suit;
    }

    public int getSuit(){
        return m_suit;
    }
}