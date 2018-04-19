import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    Driver driver;
    Driver driver2;
    Driver driver3;
    DodgemCar dodgemCar;
    QuadBike quadBike;
    Van van;

    @Before
    public void before() {
        dodgemCar = new DodgemCar(30.00, 2);
        driver = new Driver("Rachel", dodgemCar);
        quadBike = new QuadBike(40.00, 60);
        driver2 = new Driver("Max", quadBike);
        van = new Van(60.00, "M228 LYK");
        driver3 = new Driver("Grace", van);

    }

    @Test
    public void canGetName() {
        assertEquals("Rachel", driver.getName());
    }

    @Test
    public void canGetVehicle() {
        assertEquals(dodgemCar, driver.getVehicle());
        assertEquals(quadBike, driver2.getVehicle());
        assertEquals(van, driver3.getVehicle());
    }

    @Test
    public void canMeasureHowLongToDriveDistance() {
        assertEquals(2,driver.driveDistance(60));
        assertEquals(3,driver2.driveDistance(120));
        assertEquals(2,driver3.driveDistance(120));

    }

    @Test
    public void canSetVehicle() {
        driver.setVehicle(quadBike);
        driver2.setVehicle(dodgemCar);
        driver3.setVehicle(dodgemCar);

        assertEquals(quadBike, driver.getVehicle());
        assertEquals(dodgemCar, driver2.getVehicle());
        assertEquals(dodgemCar, driver3.getVehicle());
    }
}
