import Hotel.Guest;
import Hotel.Room.MealBookings.MealBooking;
import Hotel.Room.MealBookings.MealBookingType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MealBookingTest {

    private MealBooking mealBooking;
    private Guest guest1 = new Guest("Max");
    private Guest guest2 = new Guest("Nicki");
    private ArrayList<Guest> guests = new ArrayList<>(Arrays.asList(guest1, guest2));

    @Before
    public void before() {
        mealBooking = new MealBooking(MealBookingType.DINNER, "Warr", guests,0 );
    }

    @Test
    public void canGetMealBookingType() {
        assertEquals(MealBookingType.DINNER, mealBooking.getType());
    }

    @Test
    public void canGetBookingName() {
        assertEquals("Warr", mealBooking.getName());
    }

    @Test
    public void canGetGuests() {
        assertEquals(2, mealBooking.getGuestsFromBooking().size());
        assertEquals("Max",mealBooking.getGuestsFromBooking().get(0).getName());
    }

    @Test
    public void canGetBedroomNumber() {
        assertEquals(0, mealBooking.getRoomNumber());
    }
}
