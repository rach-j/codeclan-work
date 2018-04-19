import Enums.InstrumentType;
import Interfaces.IPlay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FluteTest {

    private Flute flute;

    @Before
    public void before() {
        flute = new Flute(1,150, 230,"flute","silver", "metallic");
    }

    @Test
    public void canGetMaterial() {
        assertEquals("silver", flute.getMaterial());
    }

    @Test
    public void canGetColour() {
        assertEquals("metallic", flute.getColour());
    }

    @Test
    public void canGetType() {
        assertEquals(InstrumentType.WOODWIND, flute.getType());
    }

    @Test
    public void canGetSound() {
        assertEquals("Toot toot!", flute.playSound());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(150, flute.getBuyPrice(), 0.01);
    }

    @Test
    public void canGetSellPrice() {
        assertEquals(230, flute.getSellPrice(), 0.01);
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(80, flute.markUp(), 0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("flute", flute.getDescription());
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, flute.getUniqueID());
    }

}
