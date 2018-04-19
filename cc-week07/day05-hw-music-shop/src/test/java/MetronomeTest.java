import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetronomeTest {
    private Metronome metronome;

    @Before
    public void before() {
        metronome = new Metronome(1,4.90,9.90,"metronome - mechanical Whittner");
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(4.90, metronome.getBuyPrice(),0.01);
    }

    @Test
    public void canGetSuyPrice() {
        assertEquals(9.90, metronome.getSellPrice(),0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("metronome - mechanical Whittner", metronome.getDescription());
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(5.00, metronome.markUp(),0.01);
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, metronome.getUniqueID());
    }
}
