import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;

    @Before
    public void before(){
        bus = new Bus("Marchmont", 2);
        person = new Person();
    }

    @Test
    public void canReturnNumberOfPassengers(){
        assertEquals(0, bus.numberOfPassengers());
    }

    @Test
    public void canAddPassengerIfTheBusIsNotFull(){
        bus.addPassenger(person);
        assertEquals(1, bus.numberOfPassengers());
    }

    @Test
    public void canNotAddPassengerIfBusIsFull(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.numberOfPassengers());

    }

    @Test
    public void canRemovePassengerFromBus(){
        bus.addPassenger(person);
        assertEquals(1, bus.numberOfPassengers());
        bus.removePassenger(person);
        assertEquals(0, bus.numberOfPassengers() );
    }

    @Test
    public void canPickUpPassenger(){
        busstop.addPassengerToStop(person);
        assertEquals(1, bus.numberOfPassengers());


    }
}
