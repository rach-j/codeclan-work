package Hotel.Room.MealBookings;

import Hotel.Guest;

import java.util.ArrayList;

public class MealBooking {

    private String name;
    private ArrayList<Guest> guests;
    private MealBookingType mealBookingType;
    private int bedroomNumber;
// Ask instructors - I want to have this last bedroomNumber as optional for when the reservation is for a
// guest staying at the hotel but I don't want this to be a requirement to allow for bookings from non-hotel residents
// - I know you could just set the bedroom number to (say) 0 if there is no bedroom number but is there a cleaner way?

    public MealBooking(MealBookingType mealBookingType, String name, ArrayList<Guest> guests, int bedroomNumber) {
        this.mealBookingType = mealBookingType;
        this.name = name;
        this.guests = guests;
        this.bedroomNumber = bedroomNumber;
    }

    public MealBookingType getType() {
        return this.mealBookingType;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Guest> getGuestsFromBooking() {
        return this.guests;
    }

    public int getRoomNumber() {
        return this.bedroomNumber;
    }
}


