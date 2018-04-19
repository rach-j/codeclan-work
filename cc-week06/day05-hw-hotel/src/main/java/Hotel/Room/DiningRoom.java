package Hotel.Room;

import Hotel.Guest;
import Hotel.Room.MealBookings.MealBooking;

import java.util.ArrayList;

public class DiningRoom extends Room {

    private ArrayList<MealBooking> bookings;
    private String roomName;

    public DiningRoom(RoomType roomType, int capacity, String roomName) {
        super(roomType, capacity);
        bookings = new ArrayList<>();
        this.roomName = roomName;
    }

    public ArrayList<MealBooking> getBookings() {
        return this.bookings;
    }

    public void addBooking(MealBooking mealBooking) {
        bookings.add(mealBooking);
        ArrayList<Guest> guests = mealBooking.getGuestsFromBooking();
        for(Guest guest: guests) {
            getGuests().add(guest);
        }

    }

    public String getRoomName() {
        return this.roomName;
    }
}
