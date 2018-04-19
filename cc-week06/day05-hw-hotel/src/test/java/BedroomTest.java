import Hotel.Guest;
import Hotel.Room.Bedroom;
import Hotel.Room.BedroomType;
import Hotel.Room.RoomType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BedroomTest {

    private Bedroom bedroom;
    private Guest guest;
    private Guest guest2;

    @Before
    public void before() {
        bedroom = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 1);
        guest = new Guest("Max");
        guest2 = new Guest("Nicki");
    }

    @Test
    public void canGetRoomType() {
        assertEquals(RoomType.BEDROOM, bedroom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(2,bedroom.getCapacity());
    }

    @Test
    public void canGetBedroomType() {
        assertEquals(BedroomType.DOUBLE, bedroom.getBedroomType());
    }

    @Test
    public void canGetRoomRate() {
        assertEquals(150,bedroom.getRoomRate());
    }

    @Test
    public void canGetRoomNumber() {
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void canGetGuestsWhereNoGuests() {
        assertEquals(0,bedroom.getGuests().size());
    }

    @Test
    public void canCheckWhetherBookedWhereNoGuests() {
        assertFalse(bedroom.isBooked());
    }

    @Test
    public void canAddGuestToRoom() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getGuests().size());
        assertEquals("Max",bedroom.getGuests().get(0).getName());
        assertTrue(bedroom.isBooked());
    }

    @Test
    public void canRemoveGuestFromRoomWhereGuestInRoom() {
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.getGuests().size());
        assertFalse(bedroom.isBooked());
    }

    @Test
    public void doesNotRemoveGuestFromRoomWhereGuestNotInRoom() {
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest2);
        assertEquals(1, bedroom.getGuests().size());
        assertEquals("Max",bedroom.getGuests().get(0).getName());
        assertTrue(bedroom.isBooked());
    }

    @Test
    public void canGetNightsBookedWhenNotBooked() {
        assertEquals(0,bedroom.getNightsBooked());
    }

    @Test
    public void canSetNightsBooked() {
        bedroom.setNightsBooked(2);
        assertEquals(2, bedroom.getNightsBooked());
    }

}
