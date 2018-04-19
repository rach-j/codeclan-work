import Enums.InstrumentType;
import Interfaces.IPlay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaxophoneTest {

        private Saxophone saxophone;

        @Before
        public void before() {
            saxophone = new Saxophone(1,230, 460,"saxophone","brass", "metallic");
        }

        @Test
        public void canGetMaterial() {
            assertEquals("brass", saxophone.getMaterial());
        }

        @Test
        public void canGetColour() {
            assertEquals("metallic", saxophone.getColour());
        }

        @Test
        public void canGetType() {
            assertEquals(InstrumentType.WOODWIND, saxophone.getType());
        }

        @Test
        public void canGetSound() {
            assertEquals("Doo bee doo bee doo", saxophone.playSound());
        }

        @Test
        public void canGetBuyPrice() {
        assertEquals(230, saxophone.getBuyPrice(), 0.01);
    }

        @Test
        public void canGetSellPrice() {
        assertEquals(460, saxophone.getSellPrice(), 0.01);
    }

        @Test
        public void canGetMarkUp() {
        assertEquals(230, saxophone.markUp(), 0.01);
    }

        @Test
        public void canGetDescription() {
        assertEquals("saxophone", saxophone.getDescription());
        }

        @Test
        public void canGetUniqueID() {
            assertEquals(1, saxophone.getUniqueID());
        }

}
