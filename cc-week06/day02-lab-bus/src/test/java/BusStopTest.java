import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busstop;
    Person person;

    @Before
    public void before(){
        busstop = new BusStop("Meadows");
        person = new Person();
    }

    @Test
    public void canReturnNumberOfPassengers(){
      assertEquals(0, busstop.numberOfPassengers());
    }

    @Test
    public void canAddPassengerToQueue(){
        busstop.addPassengerToStop(person);
        assertEquals(1, busstop.numberOfPassengers());

    }

    @Test
    public void canRemovePassengerFromBusStop(){
        busstop.addPassengerToStop(person);
        assertEquals(1, busstop.numberOfPassengers());
        busstop.removePassengerFromStop(person);
        assertEquals(0, busstop.numberOfPassengers() );
    }
}
