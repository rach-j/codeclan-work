import Hotel.Guest;
import Hotel.Room.ConferenceRoom;
import Hotel.Room.RoomType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;
    private ArrayList<Guest> guests;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(RoomType.CONFERENCEROOM, 100, "The Pankhurst Room");
        guest1 = new Guest("Max");
        guest2 = new Guest("Nicki");
        guest3 = new Guest("Steve");
        guests = new ArrayList<>(Arrays.asList(guest1, guest2, guest3));
    }

    @Test
    public void canGetRoomType() {
        assertEquals(RoomType.CONFERENCEROOM, conferenceRoom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(100, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetRoomName() {
        assertEquals("The Pankhurst Room", conferenceRoom.getRoomName());
    }

    @Test
    public void canGetRoomRate() {
        assertEquals(450, conferenceRoom.getRate());
    }

    @Test
    public void canGetGuestsWhereNoGuests() {
        assertEquals(0,conferenceRoom.getGuests().size());
    }

    @Test
    public void canCheckWhetherBookedWhereNoGuests() {
        assertFalse(conferenceRoom.isBooked());
    }

    @Test
    public void canAddGuestToRoom() {
        conferenceRoom.addGuests(guests);
        assertEquals(3, conferenceRoom.getGuests().size());
        assertEquals("Max",conferenceRoom.getGuests().get(0).getName());
        assertTrue(conferenceRoom.isBooked());
    }
}
