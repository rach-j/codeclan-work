import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VanTest {

    Van van;

    @Before
    public void before() {
        van = new Van(60.00, "M228 LYK");
    }

    @Test
    public void canGetAverageSpeed() {
        assertEquals(60.00, van.getAverageSpeed(),0.01);
    }

    @Test
    public void canGetRegistrationPlate() {
        assertEquals("M228 LYK", van.getRegistrationPlate());
    }

    @Test
    public void canMeasureHowLongToDriveDistance() {
        assertEquals(2, van.driveDistance(120));
    }

}
