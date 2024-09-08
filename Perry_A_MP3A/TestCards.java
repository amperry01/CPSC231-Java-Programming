public class TestCards {
    public static void main(String[] args){
    /**   
        Card card1 = new Card();
        System.out.println(card1);

        Card card2 = new Card(2, Card.DIAMONDS);
        System.out.println(card2);

        Card card3 = new Card(card1);
        System.out.println(card3);

        Card card4 = card2;

        Card card5 = new Card(Card.JACK, Card.HEARTS);
        System.out.println(card5);
    */

    /**
        Deck deck1 = new Deck();
        System.out.println(deck1);
        System.out.println(deck1.size());
        System.out.println(deck1.deal());
        System.out.println(deck1.size());
        System.out.println(deck1);
    */

        Dealer d = new Dealer();
        System.out.println(d);
        System.out.println(d.size());
        System.out.println(d.deals(5));
        System.out.println(d);
        System.out.println(d.size());
    }
}
