import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void canGetSuit() {
        assertEquals(Suit.HEARTS, card.getSuit());

    }

    @Test
    public void canGetRank() {
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void aceHasValue14() {
        assertEquals(14, card.getValue());
    }

}
