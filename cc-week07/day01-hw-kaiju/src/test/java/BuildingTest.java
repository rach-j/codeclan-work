import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest {
    Building building;

    @Before
    public void before() {
        building = new Building("House", 25);
    }

    @Test
    public void canGetType() {
        assertEquals("House", building.getType());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(25, building.getHealthValue());
    }

    @Test
    public void canReduceHealthValue() {
        building.reduceHealthValue(20);
        assertEquals(5, building.getHealthValue());
    }
}
