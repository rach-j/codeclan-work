import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player1;
    private Player player2;
    private Card card1;
    private Card card2;
    private Suit suit;
    private Rank rank;
    private Game game;

     @Before
    public void before(){
         player1 = new Player("Miguel");
         player2 = new Player("Kate");
         card1 = new Card(suit.HEARTS, rank.FOUR);
         card2 = new Card(suit.CLUBS, rank.TEN);
         game = new Game(player1, player2);
     }



     @Test
    public void canCompareHandsWithAWinner(){
        player1.addCard(card1);
        player1.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        String result = game.compareHands();
        assertEquals(0, player1.getScore());
        assertEquals(1, player2.getScore());
        assertEquals("Kate Wins", result);

     }

    @Test
    public void canCompareHandsWithADraw(){
        player1.addCard(card1);
        player2.addCard(card1);
        player1.addCard(card1);
        player2.addCard(card1);
        String result = game.compareHands();
        assertEquals(1, player1.getScore());
        assertEquals(1, player2.getScore());
        assertEquals("Miguel and Kate Draw", result);
        assertEquals(0, player1.getNumberOfCards());
        assertEquals(0, player2.getNumberOfCards());


    }
}
