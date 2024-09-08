import java.util.LinkedList;
import java.util.Random;

public class Driver {
    public static void main(String[] args){
        // Card card1 = new Card();
        // Card card2 = new Card(2, 3);
        // LinkedList<Card> hand = new LinkedList<Card>();
        // hand.add(card1);
        // hand.add(card2);
        // Player p1 = new Player(1, hand, "topBottom");
        // System.out.println(p1.getHand());
        // p1.playCard();
        // System.out.println(p1.getHand());
        // System.out.println(p1);

        // Game game = new Game(4);
        // System.out.println(game.m_players);

        Game game1 = new Game(4);
        System.out.println("The winner is Player " + game1.play() + "!!!!");

        // Game game2 = new Game();
        // System.out.println("The winner is Player " + game2.play() + "!!!!");


    }
}