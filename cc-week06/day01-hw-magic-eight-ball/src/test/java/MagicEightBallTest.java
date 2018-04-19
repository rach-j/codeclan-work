import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MagicEightBallTest {
    private MagicEightBall myResponses;

    @Before
    public void before() {
        ArrayList<String> testResponses = new ArrayList<>();
        testResponses.add("It's looking unlikely");
        testResponses.add("Not anytime soon");
        testResponses.add("Absolutely!");
        this.myResponses = new MagicEightBall(testResponses);
    }

    @Test
    public void canGetFirstResponse() {
        assertEquals("It's looking unlikely", myResponses.getResponseAtIndex(0));
    }

    @Test
    public void canGetRandom() {
        ArrayList<String> copy = myResponses.getResponses();
        String randomResponse = myResponses.getRandomResponse();
        assertTrue(copy.contains(randomResponse));
    }

    @Test

    public void canGetNumberOfResponses() {
        assertEquals(3, myResponses.getNumberOfResponses());
    }

    @Test
    public void canAddResponseToList() {
        myResponses.addResponse("Maybe if you play your cards right");
        assertEquals(4,myResponses.getNumberOfResponses());
    }

    @Test
    public void canDeleteResponse() {
        myResponses.deleteResponse(0);
        assertEquals(2, myResponses.getNumberOfResponses());
    }
}