import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarStringsTest {

    private GuitarStrings guitarStrings;

    @Before
    public void before() {
        guitarStrings = new GuitarStrings(1,2.50,4.60,"guitar strings - 5 pack", 5);
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(2.50, guitarStrings.getBuyPrice(),0.01);
    }

    @Test
    public void canGetSuyPrice() {
        assertEquals(4.60, guitarStrings.getSellPrice(),0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("guitar strings - 5 pack", guitarStrings.getDescription());
    }

    @Test
    public void canGetNumberOfStrings() {
        assertEquals(5, guitarStrings.getNumberOfStringsInPacket());
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(2.10, guitarStrings.markUp(),0.01);
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, guitarStrings.getUniqueID());
    }
}

