import java.util.LinkedList;
import java.util.Random;

public class Game {
    /**
     * a LinkedList of Players that represnets each player
     * object in order of the "circle."
     */
    private LinkedList<Player> m_players;

    /**
     * a LinkedList of Cards that represents the current 
     * pile of cards in the game.
     * last element of the pile is considered to be on "top"
     */
    public static LinkedList<Card> m_pile;

    /**
     * a Dealer member variable that holds the game's Deck of cards
     */
    private Dealer m_dealer;

    /**
     * an array of Strings that represents which special patterns
     * are valid to be slapped during the game.
     * valid patterns: doubles, sandwich, top bottom
     */
    public String[] m_patterns = {"doubles", "sandwich", "top bottom"};

    private int m_numPlayers;
    
    /**
     * member variables for static boolean methods
     */
    public static int topIdx;
    public static int nextIdx;
    public static int thirdIdx;
    public static int bottomIdx = 0;
    public static Card c1;
    public static Card c2;

    /** Default Constructor
     * initialize a game of two players
     */
    public Game(){
        m_players = new LinkedList<Player>();
        m_pile = new LinkedList<Card>();
        m_dealer = new Dealer();
        m_numPlayers = 2;
        
        /**
         * Create players
         * Deal cards to each player
         * Randomly assign pattern to each player
         */
        int cardsToDeal = m_dealer.size() / m_numPlayers;
        Random rand = new Random();

        for (int i = 1; i <= m_numPlayers; ++i){
            int patternNum = rand.nextInt(m_patterns.length);
            m_players.add(new Player(i, m_dealer.deals(cardsToDeal), m_patterns[patternNum]));
        }
    }

    /** Overloaded Constructor
     * accepts the number of players
     * @param numPlayers
     */
    public Game(int numPlayers){
        m_players = new LinkedList<Player>();
        m_pile = new LinkedList<Card>();
        m_dealer = new Dealer();
        m_numPlayers = numPlayers;
        
        /**
         * Create players
         * Deal cards to each player
         * Randomly assign pattern to each player
         */
        int cardsToDeal = m_dealer.size() / m_numPlayers;
        Random rand = new Random();

        for (int i = 1; i <= m_numPlayers; ++i){
            int patternNum = rand.nextInt(m_patterns.length);
            m_players.add(new Player(i, m_dealer.deals(cardsToDeal), m_patterns[patternNum]));
        }
    }

    /**
     * carries out rules of game until one player remains
     * @return integer of winning Player
     */
    public int play(){
        System.out.println("----------------------------------------");
        System.out.println("New game started with " + m_numPlayers + " players!");
        System.out.println(m_players);
        Player currentPlayer = m_players.get(0);
        Card card;
        while(m_players.size() > 1){
            
            card = currentPlayer.playCard();

            // check if player has cards in hand
            if (card != null) {
                m_pile.add(card);
                System.out.println("Player " + currentPlayer.getPlayerNum() + " played " + card);

                // check if face card
                if(isFace(card)){
                    System.out.println("It's a face card!");
                    // handle face-off case
                    currentPlayer = faceOff(currentPlayer, card);
                }
                else if (currentPlayer.slaps(m_pile)){
                    // if true
                    System.out.println("Player " + currentPlayer.getPlayerNum() + " slaps and gets the pile");
                    // add every card from pile to players hand
                    for (Card c: m_pile){
                        currentPlayer.getHand().add(c);
                    }
                    // empty pile list
                    m_pile.clear();
                }

                // check if player still has cards
                if (currentPlayer.getHand().size() == 0){
                    System.out.println("Player " + currentPlayer.getPlayerNum() + " ran out of cards");
                    m_players.remove(currentPlayer);
                }
            }
            else if (card == null){ // a redundancy to remove player if not removed after playing last card
                System.out.println("Player " + currentPlayer.getPlayerNum() + " ran out of cards");
                m_players.remove(currentPlayer);
            }

            // next player
            currentPlayer = nextPlayer(currentPlayer);
        }

        return m_players.get(0).getPlayerNum();
    }

    private boolean isFace(Card c){
        boolean temp = false;
        if (c.getRank() == Card.JACK){
            return true;
        }
        else if (c.getRank() == Card.QUEEN){
            return true;
        }
        else if (c.getRank() == Card.KING){
            return true;
        }
        else if (c.getRank() == Card.ACE){
            return true;
        }
        return false;
    }

    /**
     * @return Player object of next player in circle after current player
     * helpful during face-card face-offs
     */
    private Player nextPlayer(Player currentPlayer){
        /**
         * get next player
         * modulo to wrap around player list modulo from Kamron Swingle
         * This method is very similar to what Kamron Swingle used as he helped me with the modulo function.
         */
        int nextPlayerIdx = (m_players.indexOf(currentPlayer) + 1) % m_players.size();
        return m_players.get(nextPlayerIdx);
    }

    /**
     * handles face-card face-off
     * @return next player aka the player doing the face off
     */
    private Player faceOff(Player currentPlayer, Card faceCard){
        Card card;
        Player faceOffPlayer = nextPlayer(currentPlayer);

        if (faceOffPlayer.getHand().size() == 0){
            System.out.println("Player " + faceOffPlayer.getPlayerNum() + " ran out of cards");
            m_players.remove(faceOffPlayer);
            return faceOffPlayer;
        }
        card = faceOffPlayer.playCard();
        
        // JACK 1 try
        if (faceCard.getRank() == Card.JACK){
            if (card != null) {
                m_pile.add(card);
                System.out.println("Player " + faceOffPlayer.getPlayerNum() + " played " + card);
                // if first card is a face card, face-off continues 
                if (isFace(card)){
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " wins the face-off");
                    //currentPlayer = faceOff(faceOffPlayer, card);
                } // if not a face card, currentPlayer takes pile and return faceOffPlayer
                else if (!isFace(card)){
                    System.out.println("Player " + currentPlayer.getPlayerNum() + " wins the face-off");
                    // add every card from pile to players hand
                    for (Card c: m_pile){
                        currentPlayer.getHand().add(c);
                    }
                    // empty pile list
                    m_pile.clear();
                }
            }
        }
        // QUEEN 2 trys
        else if (faceCard.getRank() == Card.QUEEN){
            // run through 2x 
            for (int i = 0; i < 2; i++){
                // check if player still has cards
                if (faceOffPlayer.getHand().size() == 0){
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " ran out of cards");
                    m_players.remove(faceOffPlayer);
                    break;
                }
                card = faceOffPlayer.playCard();
                if (card != null) {
                    m_pile.add(card);
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " played " + card);
                    if (isFace(card)){
                        System.out.println("Player " + faceOffPlayer.getPlayerNum() + " wins the face-off");
                        //currentPlayer = faceOff(faceOffPlayer, card);
                        break;
                    }
                }
            } 
            // if no cards played are a face car 
            if (!isFace(card)){
                System.out.println("Player " + currentPlayer.getPlayerNum() + " wins the face-off");
                // add every card from pile to players hand
                for (Card c: m_pile){
                    currentPlayer.getHand().add(c);
                }
                // empty pile list
                m_pile.clear();
            }
        }
        // KING 3 trys
        else if (faceCard.getRank() == Card.KING){
            // run through 3x
            for (int i = 0; i < 3; i++){
                // check if player still has cards
                if (faceOffPlayer.getHand().size() == 0){
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " ran out of cards");
                    m_players.remove(faceOffPlayer);
                    break;
                }
                card = faceOffPlayer.playCard();
                if (card != null) {
                    m_pile.add(card);
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " played " + card);
                    if (isFace(card)){
                        System.out.println("Player " + faceOffPlayer.getPlayerNum() + " wins the face-off");
                        //currentPlayer = faceOff(faceOffPlayer, card);
                        break;
                    }
                }
            } 
            // if no cards played are a face card 
            if (!isFace(card)){
                System.out.println("Player " + currentPlayer.getPlayerNum() + " wins the face-off");
                // add every card from pile to players hand
                for (Card c: m_pile){
                    currentPlayer.getHand().add(c);
                }
                // empty pile list
                m_pile.clear();
            }
        }
        // ACE 4 trys
        else if (faceCard.getRank() == Card.ACE){
            // run through 4x
            for (int i = 0; i < 4; i++){
                // check if player still has cards
                if (faceOffPlayer.getHand().size() == 0){
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " ran out of cards");
                    m_players.remove(faceOffPlayer);
                    break;
                }
                card = faceOffPlayer.playCard();
                if (card != null) {
                    m_pile.add(card);
                    System.out.println("Player " + faceOffPlayer.getPlayerNum() + " played " + card);
                    if (isFace(card)){
                        System.out.println("Player " + faceOffPlayer.getPlayerNum() + " wins the face-off");
                        //currentPlayer = faceOff(faceOffPlayer, card);
                        break;
                    }
                }
            } 
            // if no cards played are a face car 
            if (!isFace(card)){
                System.out.println("Player " + currentPlayer.getPlayerNum() + " wins the face-off");
                // add every card from pile to players hand
                for (Card c: m_pile){
                    currentPlayer.getHand().add(c);
                }
                // empty pile list
                m_pile.clear();
            }
        }

        return faceOffPlayer;

    }

    /** static methods for each pattern 
     * accepts a LinkedList for Game's pile
     * @param 
     * @return boolean for if pattern is valid or not
     */
    static boolean doubles(LinkedList<Card> pile){
        if(pile.size() > 1){
            topIdx = pile.size() - 1;
            nextIdx = pile.size() - 2;
            c1 = pile.get(topIdx);
            c2 = pile.get(nextIdx);

            if (c1.equals(c2)){
                return true;
            }
        }

        return false;
    }

    static boolean sandwich(LinkedList<Card> pile){
        if (pile.size() > 2){
            topIdx = pile.size() - 1;
            thirdIdx = pile.size() - 3;
            c1 = pile.get(topIdx);
            c2 = pile.get(thirdIdx);

            if (c1.equals(c2)){
                return true;
            }
        }

        return false;
    }

    static boolean topBottom(LinkedList<Card> pile){
        if (pile.size() > 3){
            topIdx = pile.size() - 1;
            c1 = pile.get(topIdx);
            c2 = pile.get(bottomIdx);

            if (c1.equals(c2)){
                return true;
            }
        }

        return false;
    }

    /**
     * Accessor Methods
     */
    public LinkedList<Player> getPlayers(){
        return m_players;
    }

    public LinkedList<Card> getPile(){
        return m_pile;
    }

    public Dealer getDealer(){
        return m_dealer;
    }
    
    public String[] getPatterns(){
        return m_patterns;
    }
}