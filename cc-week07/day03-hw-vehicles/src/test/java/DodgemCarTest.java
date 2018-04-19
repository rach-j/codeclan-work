import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DodgemCarTest {

    DodgemCar dodgemCar;

    @Before
    public void before() {
        dodgemCar = new DodgemCar(30.00, 2);
    }

    @Test
    public void hasAverageSpeed() {
        assertEquals(30.00, dodgemCar.getAverageSpeed(),0.01);
    }

    @Test
    public void hasNumberOfSeats() {
        assertEquals(2, dodgemCar.getNumberOfSeats());
    }

    @Test
    public void canMeasureHowLongToDriveDistance() {
        assertEquals(2, dodgemCar.driveDistance(60));
    }
//    Function returns complete number of units of time (so e.g. function returns 1 for distance 59
}
