import Enums.InstrumentType;
import Interfaces.IPlay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrumKitTest {
    private DrumKit drumKit;

    @Before
    public void before() {
        drumKit = new DrumKit(1,159, 299, "drum kit","mixed", "blue", 2, 4);
    }

    @Test
    public void canGetMaterial() {
        assertEquals("mixed", drumKit.getMaterial());
    }

    @Test
    public void canGetColour() {
        assertEquals("blue", drumKit.getColour());
    }

    @Test
    public void canGetType() {
        assertEquals(InstrumentType.PERCUSSION, drumKit.getType());
    }

    @Test
    public void canGetSound() {
        assertEquals("Bang bang, crash!", drumKit.playSound());
    }

    @Test
    public void canGetNumberOfCymbals() {
        assertEquals(2, drumKit.getNumberOfCymbals());
    }

    @Test
    public void canGetNumberOfDrums() {
        assertEquals(4, drumKit.getNumberOfDrums());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(159, drumKit.getBuyPrice(), 0.01);
    }

    @Test
    public void canGetSellPrice() {
        assertEquals(299, drumKit.getSellPrice(), 0.01);
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(140, drumKit.markUp(), 0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("drum kit", drumKit.getDescription());
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, drumKit.getUniqueID());
    }

}
