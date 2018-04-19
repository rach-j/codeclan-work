import Enums.InstrumentType;
import Interfaces.IPlay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrumpetTest {
    private Trumpet trumpet;

    @Before
    public void before() {
        trumpet = new Trumpet(1,180, 260,"trumpet","brass", "metallic");
    }

    @Test
    public void canGetMaterial() {
        assertEquals("brass", trumpet.getMaterial());
    }

    @Test
    public void canGetColour() {
        assertEquals("metallic", trumpet.getColour());
    }

    @Test
    public void canGetType() {
        assertEquals(InstrumentType.BRASS, trumpet.getType());
    }

    @Test
    public void canGetSound() {
        assertEquals("Parp parp!", trumpet.playSound());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(180, trumpet.getBuyPrice(), 0.01);
    }

    @Test
    public void canGetSellPrice() {
        assertEquals(260, trumpet.getSellPrice(), 0.01);
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(80, trumpet.markUp(), 0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("trumpet", trumpet.getDescription());
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, trumpet.getUniqueID());
    }
}
