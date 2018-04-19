import org.junit.Before;
import org.junit.Test;
import universe.BigBang;
import universe.Universe;
import static org.junit.Assert.assertEquals;

public class TestUniverse {
    private BigBang god;

    @Before
    public void before() {
    god = new BigBang();
    }

    @Test
    public void BigBangCanMakeUniverse() {
        Universe universe1 = god.makeUniverse("Hawkins Universe", 18);
        assertEquals("Hawkins Universe", universe1.getName());
    }

    @Test
    public void moreThanInstanceCanNotBeMadeJustNewReferences() {
        // Can't write over an instance
        Universe universe1 = god.makeUniverse("Blue Space", 10);
        // Can't create a second instance
        Universe universe2 = god.makeUniverse("Pink Space", 20);
        assertEquals("Hawkins Universe", universe1.getName());
        assertEquals(18, universe1.getNumberOfGalaxies());
        assertEquals("Hawkins Universe", universe2.getName());
        assertEquals(18, universe2.getNumberOfGalaxies());
    }

    @Test
    public void changeNameInSecondReferenceUniverseWhichChangesFirstCOSTHEYISTHESAME() {
        Universe universe1 = god.makeUniverse("Blue Space", 10);
        Universe universe2 = god.makeUniverse("Pink Space", 20);
        universe2.setName("Yellow Space");
        assertEquals("Yellow Space", universe2.getName());
        assertEquals("Yellow Space", universe1.getName());
    }
}
