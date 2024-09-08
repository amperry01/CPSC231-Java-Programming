import java.util.LinkedList;
import java.util.Random;

public class Dealer {
    public Deck m_deck;

    // default constructor
    public Dealer(){
        m_deck = new Deck();
    }

    // deals n cards randomly from the deck
    public LinkedList<Card> deals(int n){
        LinkedList<Card> dealtCards = new LinkedList<Card>();
        Random rand = new Random();

        for(int i = 0; i < n; i++){
            /** check if 0 cards in deck
             * will break if size is 0
             * if not enough cards to deal, will add to dealtCards until deck is 0. */
            if (m_deck.size() == 0){
                break;
            }

            // get random card from deck
            int idxToDeal = rand.nextInt(m_deck.size());
            Card c = m_deck.m_cards.get(idxToDeal);
            
            // add card to dealtCards linked list
            dealtCards.add(c);

            // remove card from original deck
            m_deck.m_cards.remove(idxToDeal);
        }
        return dealtCards;
    }

    public int size(){
        return m_deck.size();
    }

    public String toString(){
        return m_deck.toString();
    }
}