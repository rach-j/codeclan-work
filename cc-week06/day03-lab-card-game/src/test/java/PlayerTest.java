import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Deck deck;
    private Card card;
    private Rank rank;
    private Suit suit;

    @Before
    public void before() {
        player = new Player("Miguel");
        deck = new Deck();
        card = new Card(suit.HEARTS, rank.SIX);

    }

    @Test
    public void canGetScore() {
        assertEquals(0, player.getScore());
    }



    @Test
    public void canIncreaseScore() {
        player.increaseScore();
        assertEquals(1,player.getScore());
    }

    @Test
    public void canGetNumberOfCards() {
        assertEquals(0, player.getNumberOfCards());
    }

    @Test
    public void canTakeCardFromDeck() {
        player.takesCard(deck);
        assertEquals(1, player.getNumberOfCards());
        assertEquals(51, deck.CardCount());
    }

    @Test
    public void canAddCardToPlayer(){
        player.addCard(card);
        assertEquals(1, player.getNumberOfCards());
    }

    @Test
    public void canGetName(){
        assertEquals("Miguel", player.getName());
    }


    @Test
    public void canGetCardHand(){
        player.addCard(card);
        assertEquals(card, player.getFirstCard());

    }

    @Test
    public void canResetHand(){
        player.addCard(card);
        player.resetHand();
        assertEquals(0, player.getNumberOfCards());
    }

    @Test
    public void canGetTotalValueOfHand() {
        player.addCard(card);
        player.addCard(card);
        assertEquals(12,player.getTotalValue());
    }


}
