import Hotel.Guest;
import Hotel.Room.DiningRoom;
import Hotel.Room.MealBookings.MealBooking;
import Hotel.Room.MealBookings.MealBookingType;
import Hotel.Room.RoomType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DininingRoomTest {

    private DiningRoom diningRoom;
    private MealBooking mealBooking;
    private Guest guest1 = new Guest("Max");
    private Guest guest2 = new Guest("Nicki");
    private ArrayList<Guest> guests = new ArrayList<>(Arrays.asList(guest1, guest2));



    @Before
    public void before() {
        diningRoom = new DiningRoom(RoomType.DININGROOM, 80, "The Dining Room");
        mealBooking = new MealBooking(MealBookingType.DINNER,"Warr", guests, 0);
    }

    @Test
    public void canGetRoomType() {
        assertEquals(RoomType.DININGROOM, diningRoom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(80, diningRoom.getCapacity());
    }

    @Test
    public void canGetRoomName() {
        assertEquals("The Dining Room", diningRoom.getRoomName());
    }

    @Test
    public void canGetBookingsWhereNoBookings() {
        assertEquals(0, diningRoom.getBookings().size());
    }

    @Test
    public void canAddBooking() {
        diningRoom.addBooking(mealBooking);
        assertEquals(1, diningRoom.getBookings().size());
        assertEquals("Warr", diningRoom.getBookings().get(0).getName());
        assertEquals(2, diningRoom.getGuests().size());
        assertEquals("Max", diningRoom.getGuests().get(0).getName());
    }
}
