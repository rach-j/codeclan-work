import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> newDeck;

//    public Deck() {
//        this.newDeck = new Card[52];
//        int i = 0;
//        for(Suit suit: Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                newDeck[i] = new Card(suit, rank);
//                i++;
//            }
//        }
//    }

    public Deck() {
        this.newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card newCard = new Card(suit, rank);
                newDeck.add(newCard);
            }
        }
    }

    public int CardCount() {
        int count = 0;
        for (int i = 0; i < newDeck.size(); i++) {
            if (newDeck.get(i) != null) {
                count++;
            }
        }
        return count;
    }


    public Card removeCard() {
        Random rand = new Random();
        int n = rand.nextInt(51);
        Card removedCard = newDeck.get(n);
        newDeck.remove(removedCard);
        return removedCard;
    }

    public void newDeck() {
        this.newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card newCard = new Card(suit, rank);
                newDeck.add(newCard);
            }
        }

    }

}
