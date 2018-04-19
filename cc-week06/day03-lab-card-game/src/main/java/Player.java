import java.util.ArrayList;

public class Player {

    private String name;
    private int score;
    private ArrayList<Card> cardhand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.cardhand = new ArrayList<>();
    }

    public int getScore() {
        return this.score;
    }

    public void increaseScore() {
        this.score +=1;
    }

    public int getNumberOfCards() {
        return cardhand.size();
    }

    public Card takesCard(Deck deck) {
        Card removedCard = deck.removeCard();
        cardhand.add(removedCard);
        return removedCard;
    }

    public void addCard(Card card) {
        cardhand.add(card);
    }

    public String getName() {
        return this.name;
    }

    public Card getFirstCard() {
        return this.cardhand.get(0);
    }

    public void resetHand() {
        this.cardhand = new ArrayList<>();
    }

    public int getTotalValue() {
        int totalValue = 0;
        for (int i=0; i < cardhand.size(); i++) {
            totalValue += cardhand.get(i).getValue();
        }
        return totalValue;
    }
}
