import Hotel.Guest;
import Hotel.Hotel;
import Hotel.Room.*;
import Hotel.Room.MealBookings.MealBooking;
import Hotel.Room.MealBookings.MealBookingType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HotelTest {

    private Hotel ccHotel;
    private MealBooking mealBooking1;
    private MealBooking mealBooking2;
    private MealBooking mealBooking3;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;
    private Guest guest4;
    private ArrayList<Guest> guests1;
    private ArrayList<Guest> guests2;
    private ArrayList<Guest> guests3;
    private ArrayList<Guest> guests4;
    private ArrayList<Guest> guests5;


    @Before
    public void before() {
        ccHotel = new Hotel();

        guest1 = new Guest("Max");
        guest2 = new Guest("Nicki");
        guest3 = new Guest("Steve");
        guest4 = new Guest("Rachel");

        guests1 = new ArrayList<>(Arrays.asList(guest1,guest2));
        guests2 = new ArrayList<>(Arrays.asList(guest1, guest2, guest3));
        guests3 = new ArrayList<>(Arrays.asList(guest1, guest2, guest3, guest4));
        guests4 = new ArrayList<>(Arrays.asList(guest1));
        guests5 = new ArrayList<>(Arrays.asList(guest2));

        mealBooking1 = new MealBooking(MealBookingType.DINNER, "Warr", guests1,0);
        mealBooking2 = new MealBooking(MealBookingType.DINNER, "Warr", guests2,0);
        mealBooking3 = new MealBooking(MealBookingType.DINNER, "Warr", guests3,0);
    }

    @Test
    public void canGetBedroomByNumber() {
        assertEquals(9,ccHotel.getBedroomByNumber(9).getRoomNumber());
        assertEquals(RoomType.BEDROOM,ccHotel.getBedroomByNumber(9).getType());
        assertEquals(BedroomType.FAMILY,ccHotel.getBedroomByNumber(9).getBedroomType());
        assertEquals(3,ccHotel.getBedroomByNumber(9).getCapacity());
    }

    @Test
    public void canCheckGuestsIntoBedroomWhereEmptyAndCapacityGreaterThanGuests() {
        ccHotel.checkInGuests(3, guests1,1);
        Bedroom bedroom = ccHotel.getBedroomByNumber(3);
        assertEquals(2, bedroom.getGuests().size());
        assertEquals("Max",bedroom.getGuests().get(0).getName());
        assertEquals(1,bedroom.getNightsBooked());
        assertTrue(bedroom.isBooked());
    }

    @Test
    public void doesNotCheckGuestsIntoBedroomWhereNotEmpty() {
        ccHotel.checkInGuests(3, guests4, 2);
        ccHotel.checkInGuests(3, guests5, 3);
        Bedroom bedroom = ccHotel.getBedroomByNumber(3);
        assertEquals(1, bedroom.getGuests().size());
        assertEquals("Max",bedroom.getGuests().get(0).getName());
        assertEquals(2,bedroom.getNightsBooked());
        assertTrue(bedroom.isBooked());
    }

    @Test
    public void doesNotCheckGuestsIntoBedroomWhereEmptyButCapacityLessThanGuests() {
        ccHotel.checkInGuests(3, guests2, 2);
        Bedroom bedroom = ccHotel.getBedroomByNumber(3);
        assertEquals(0, bedroom.getGuests().size());
        assertFalse(bedroom.isBooked());
        assertEquals(0,bedroom.getNightsBooked());
    }

    @Test
    public void canCheckGuestsOutOfRoomWhereGuestsInRoom() {
        ccHotel.checkInGuests(3, guests1, 2);
        ccHotel.checkOutGuests(3,guests1);
        Bedroom bedroom = ccHotel.getBedroomByNumber(3);
        assertEquals(0, bedroom.getGuests().size());
        assertFalse(bedroom.isBooked());
        assertEquals(0,bedroom.getNightsBooked());
    }

    @Test
    public void doesNotCheckGuestsOutOfRoomWhereGuestsNotInRoom() {
        ccHotel.checkInGuests(3, guests4, 2);
        ccHotel.checkOutGuests(3,guests5);
        Bedroom bedroom = ccHotel.getBedroomByNumber(3);
        assertEquals(1, bedroom.getGuests().size());
        assertTrue(bedroom.isBooked());
        assertEquals(2,bedroom.getNightsBooked());
    }

    @Test
    public void canGetGuestsFromBedroom() {
        ccHotel.checkInGuests(3, guests1, 2);
        assertEquals(2, ccHotel.getGuests(3).size());
        assertEquals("Max",ccHotel.getGuests(3).get(0).getName());
    }

    @Test
    public void canGetConferenceRoomByName() {
        assertEquals("The Pankhurst Room",ccHotel.getConferenceRoomByName("The Pankhurst Room").getRoomName());
        assertEquals(RoomType.CONFERENCEROOM,ccHotel.getConferenceRoomByName("The Pankhurst Room").getType());
        assertEquals(100,ccHotel.getConferenceRoomByName("The Pankhurst Room").getCapacity());
    }

    @Test
    public void canAddConferenceBookingWhereConferenceRoomEmptyAndGuestsToBeAddedUnderCapacity() {
        ccHotel.addConferenceBooking("The Pankhurst Room", guests1);
        ConferenceRoom conferenceRoom = ccHotel.getConferenceRoomByName("The Pankhurst Room");
        assertEquals(2, conferenceRoom.getGuests().size());
        assertEquals("Max",conferenceRoom.getGuests().get(0).getName());
        assertTrue(conferenceRoom.isBooked());
    }

    @Test
    public void doesNotAddConferenceBookingWhereConferenceRoomNotEmpty() {
        ccHotel.addConferenceBooking("The Pankhurst Room", guests1);
        ccHotel.addConferenceBooking("The Pankhurst Room", guests2);
        ConferenceRoom conferenceRoom = ccHotel.getConferenceRoomByName("The Pankhurst Room");
        assertEquals(2, conferenceRoom.getGuests().size());
        assertTrue(conferenceRoom.isBooked());
    }

    @Test
    public void doesNotAddConferenceBookingWhereNumberOfGuestsGreaterThanCapacity() {
        ccHotel.addConferenceBooking("The Wilding Davison Room", guests3);
        ConferenceRoom conferenceRoom = ccHotel.getConferenceRoomByName("The Wilding Davison Room");
        assertEquals(0, conferenceRoom.getGuests().size());
        assertFalse(conferenceRoom.isBooked());
    }

    @Test
    public void canGetGuestsFromConferenceRoom() {
        ccHotel.addConferenceBooking("The Pankhurst Room", guests1);
        assertEquals(2, ccHotel.getGuestsFromConferenceRoom("The Pankhurst Room").size());
        assertEquals("Max",ccHotel.getGuestsFromConferenceRoom("The Pankhurst Room").get(0).getName());
    }

    @Test
    public void canGetDiningRoomByName() {
        assertEquals("The Dining Room",ccHotel.getDiningRoomByName("The Dining Room").getRoomName());
        assertEquals(RoomType.DININGROOM,ccHotel.getDiningRoomByName("The Dining Room").getType());
        assertEquals(5,ccHotel.getDiningRoomByName("The Dining Room").getCapacity());
    }

    @Test
    public void canAddMealBookingWhereBookingToBeAddedDoesNotLeadToCapacityBeingExceeded() {
        ccHotel.addMealBooking("The Dining Room", mealBooking1);
        DiningRoom diningRoom = ccHotel.getDiningRoomByName("The Dining Room");
        assertEquals(2, diningRoom.getGuests().size());
        assertEquals("Max", diningRoom.getGuests().get(0).getName());
        assertEquals(1, diningRoom.getBookings().size());
    }

    @Test
    public void DoesNotAddMealBookingWhereBookingWouldLeadToCapacityBeingExceeded() {
        ccHotel.addMealBooking("The Dining Room", mealBooking1);
        ccHotel.addMealBooking("The Dining Room", mealBooking2);
        ccHotel.addMealBooking("The Dining Room", mealBooking3);
        DiningRoom diningRoom = ccHotel.getDiningRoomByName("The Dining Room");
        assertEquals(5, diningRoom.getGuests().size());
        assertEquals(2,diningRoom.getBookings().size());
    }

    @Test
    public void canGetGuestsFromDiningRoom() {
        ccHotel.addMealBooking("The Dining Room", mealBooking1);
        assertEquals(2, ccHotel.getGuestsFromDiningRoom("The Dining Room").size());
        assertEquals("Max",ccHotel.getGuestsFromDiningRoom("The Dining Room").get(0).getName());
    }

    @Test
    public void canReturnListOfVacantBedrooms() {
        ccHotel.checkInGuests(1,guests4, 2);
        ccHotel.checkInGuests(3,guests1, 2);
        assertEquals(8,ccHotel.getVacantRooms().size());
        assertTrue(ccHotel.getVacantRooms().contains(ccHotel.getBedroomByNumber(2)));
        assertFalse(ccHotel.getVacantRooms().contains(ccHotel.getBedroomByNumber(1)));
    }

}
