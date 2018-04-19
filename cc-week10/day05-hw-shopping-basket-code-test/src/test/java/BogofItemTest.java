import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BogofItemTest {
    private BogofItem item1;

    @Before
    public void before() {
        item1 = new BogofItem(1,"Diet Coke - 6 pack", 4.50);
    }

    @Test
    public void canGetId() {
        assertEquals(1, item1.getId());
    }

    @Test
    public void canGetName() {
        assertEquals("Diet Coke - 6 pack", item1.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(4.50, item1.getPrice(),0.01);
    }

    @Test
    public void canGetBogofStatus() {
        assertTrue(item1.getBogofStatus());
    }
}
