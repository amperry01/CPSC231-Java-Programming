import java.util.LinkedList;
import java.util.Random;

public class Deck {
    public LinkedList<Card> m_cards;

    // default constructor, standard deck of 52 cards
    public Deck(){
        m_cards = new LinkedList<Card>();

        // hearts, 13
        for (int i = 2; i < 11; ++i){
            Card c = new Card(i, Card.HEARTS);
            m_cards.add(c);
        }

        Card jH = new Card(Card.JACK, Card.HEARTS);
        Card qH = new Card(Card.QUEEN, Card.HEARTS);
        Card kH = new Card(Card.KING, Card.HEARTS);
        Card aH = new Card(Card.ACE, Card.HEARTS);

        m_cards.add(jH);
        m_cards.add(qH);
        m_cards.add(kH);
        m_cards.add(aH);

        // spades, 13
        for (int i = 2; i < 11; ++i){
            Card c = new Card(i, Card.SPADES);
            m_cards.add(c);
        }

        Card jS = new Card(Card.JACK, Card.SPADES);
        Card qS = new Card(Card.QUEEN, Card.SPADES);
        Card kS = new Card(Card.KING, Card.SPADES);
        Card aS = new Card(Card.ACE, Card.SPADES);

        m_cards.add(jS);
        m_cards.add(qS);
        m_cards.add(kS);
        m_cards.add(aS);

        // clubs, 13
        for (int i = 2; i < 11; ++i){
            Card c = new Card(i, Card.CLUBS);
            m_cards.add(c);
        }
        
        Card jC = new Card(Card.JACK, Card.CLUBS);
        Card qC = new Card(Card.QUEEN, Card.CLUBS);
        Card kC = new Card(Card.KING, Card.CLUBS);
        Card aC = new Card(Card.ACE, Card.CLUBS);

        m_cards.add(jC);
        m_cards.add(qC);
        m_cards.add(kC);
        m_cards.add(aC);

        // diamonds, 13
        for (int i = 2; i < 11; ++i){
            Card c = new Card(i, Card.DIAMONDS);
            m_cards.add(c);
        }
        
        Card jD = new Card(Card.JACK, Card.DIAMONDS);
        Card qD = new Card(Card.QUEEN, Card.DIAMONDS);
        Card kD = new Card(Card.KING, Card.DIAMONDS);
        Card aD = new Card(Card.ACE, Card.DIAMONDS);

        m_cards.add(jD);
        m_cards.add(qD);
        m_cards.add(kD);
        m_cards.add(aD);
    }

    // copy constructor
    public Deck(Deck deckToCopy){
        m_cards = new LinkedList<Card>();
        for(Card c: deckToCopy.m_cards){
            m_cards.add(new Card(c));
        }
    }

    // toString method
    public String toString(){
        String s = "";
        s += "Cards in deck: ";
        s += "\n" + m_cards.toString();
        return s;
    }
    
    public int size(){
        return m_cards.size();
    }

    public Card deal(){
        Random rand = new Random();
        int idxToRemove = rand.nextInt(m_cards.size());
        Card cardToRemove = m_cards.get(idxToRemove);
        m_cards.remove(idxToRemove);
        return cardToRemove;
    }
}