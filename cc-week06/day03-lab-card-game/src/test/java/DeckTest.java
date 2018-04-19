import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;
    private Card card;
    private Rank rank;
    private Suit suit;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void checkDeckFull() {
        assertEquals(52, deck.CardCount());
    }

    @Test
    public void canRemoveCard(){
        deck.removeCard();
        assertEquals(51, deck.CardCount());

    }

    @Test
    public void canGenerateNewDeck(){
        deck.newDeck();
        assertEquals(52, deck.CardCount());
    }

}


