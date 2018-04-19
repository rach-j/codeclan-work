import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadBikeTest {

    QuadBike quadBike;

    @Before
    public void before() {
        quadBike = new QuadBike(40.00, 60);
    }

    @Test
    public void canGetAverageSpeed() {
        assertEquals(40.00, quadBike.getAverageSpeed(), 0.01);
    }

    @Test
    public void canGetEngineCapacity() {
        assertEquals(60, quadBike.getEngineCapacity());
    }

    @Test
    public void canMeasureHowLongToDriveDistance() {
        assertEquals(3, quadBike.driveDistance(120));
    }
//    Function returns complete number of units of time (so e.g. function returns 1 for distance 59
}
