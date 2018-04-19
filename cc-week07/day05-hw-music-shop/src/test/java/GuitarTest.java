import Enums.GuitarType;
import Enums.InstrumentType;
import Interfaces.IPlay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarTest {

    private Guitar guitar;
    private GuitarType guitarType;

    @Before
    public void before() {
        guitar = new Guitar(1,350, 490,"guitar","maple", "surf green", guitarType.ELECTRIC, 6);
    }

    @Test
    public void canGetMaterial() {
        assertEquals("maple", guitar.getMaterial());
    }

    @Test
    public void canGetColour() {
        assertEquals("surf green", guitar.getColour());
    }

    @Test
    public void canGetType() {
        assertEquals(InstrumentType.STRING, guitar.getType());
    }

    @Test
    public void canGetSound() {
        assertEquals("Strum strum", guitar.playSound());
    }

    @Test
    public void canGetGuitarType() {
        assertEquals(GuitarType.ELECTRIC, guitar.getGuitarType());
    }

    @Test
    public void canGetNumberOfStrings() {
        assertEquals(6, guitar.getNumberOfStrings());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(350, guitar.getBuyPrice(), 0.01);
    }

    @Test
    public void canGetSellPrice() {
        assertEquals(490,guitar.getSellPrice(), 0.01);
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(140, guitar.markUp(), 0.01);
    }

    @Test
    public void canGetDescription() {
        assertEquals("guitar", guitar.getDescription());
    }

    @Test
    public void canGetUniqueID() {
        assertEquals(1, guitar.getUniqueID());
    }

}
