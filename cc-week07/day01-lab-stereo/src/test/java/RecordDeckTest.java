import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordDeckTest {

    private RecordDeck recordDeck;

    @Before
    public void before() {
        recordDeck = new RecordDeck("Sony", "S23", 45);
    }

    @Test
    public void cnaGetMake(){
        assertEquals("Sony", recordDeck.getMake());

    }

    @Test
    public void canGetModel() {
        assertEquals("S23", recordDeck.getModel());
    }

    @Test
    public void canGetPlaySpeed() {
        assertEquals(45, recordDeck.getPlaySpeed());
    }

    @Test
    public void canPlaySong() {
        assertEquals("I am playing on LP Dancing in the Moonlight", recordDeck.play("Dancing in the Moonlight"));
    }
}
