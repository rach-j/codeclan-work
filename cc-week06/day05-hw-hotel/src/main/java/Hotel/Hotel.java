package Hotel;

import Hotel.Room.*;
import Hotel.Room.MealBookings.MealBooking;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom>  diningRooms;

    public Hotel() {
        Bedroom bedroom1 = new Bedroom(RoomType.BEDROOM, 1, BedroomType.SINGLE, 1);
        Bedroom bedroom2 = new Bedroom(RoomType.BEDROOM, 1, BedroomType.SINGLE, 2);
        Bedroom bedroom3 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 3);
        Bedroom bedroom4 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 4);
        Bedroom bedroom5 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 5);
        Bedroom bedroom6 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 6);
        Bedroom bedroom7 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 7);
        Bedroom bedroom8 = new Bedroom(RoomType.BEDROOM, 2, BedroomType.DOUBLE, 8);
        Bedroom bedroom9 = new Bedroom(RoomType.BEDROOM, 3, BedroomType.FAMILY, 9);
        Bedroom bedroom10 = new Bedroom(RoomType.BEDROOM, 3, BedroomType.FAMILY, 10);

        ConferenceRoom conferenceRoom1 = new ConferenceRoom(RoomType.CONFERENCEROOM,100, "The Pankhurst Room");
        ConferenceRoom conferenceRoom2 = new ConferenceRoom(RoomType.CONFERENCEROOM,3, "The Wilding Davison Room");
        ConferenceRoom conferenceRoom3 = new ConferenceRoom(RoomType.CONFERENCEROOM,100, "The Wallace Dunlop Room");

        DiningRoom diningRoom1 = new DiningRoom(RoomType.DININGROOM, 5, "The Dining Room");

        this.bedrooms = new ArrayList<>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        bedrooms.add(bedroom3);
        bedrooms.add(bedroom4);
        bedrooms.add(bedroom5);
        bedrooms.add(bedroom6);
        bedrooms.add(bedroom7);
        bedrooms.add(bedroom8);
        bedrooms.add(bedroom9);
        bedrooms.add(bedroom10);

        this.conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conferenceRoom1);
        conferenceRooms.add(conferenceRoom2);
        conferenceRooms.add(conferenceRoom3);

        this.diningRooms = new ArrayList<>();
        diningRooms.add(diningRoom1);
    }

    public Bedroom getBedroomByNumber(int i) {
        Bedroom found = this.bedrooms.get(0);
        for (Bedroom bedroom: this.bedrooms) {
            if (i == bedroom.getRoomNumber()) {
                found = bedroom;
            }
        }
        return found;
    }
// Ask instructors re setting default to first bedroom = issues if bedroom not found (and similar for conf rooms and
// dining rooms)

    public ConferenceRoom getConferenceRoomByName(String name) {
        ConferenceRoom found = this.conferenceRooms.get(0);
        for (ConferenceRoom conferenceRoom: this.conferenceRooms) {
            if (name == conferenceRoom.getRoomName()) {
                found = conferenceRoom;
            }
        }
        return found;
    }

    public DiningRoom getDiningRoomByName(String name) {
        DiningRoom found = this.diningRooms.get(0);
        for (DiningRoom diningRoom: this.diningRooms) {
            if (name == diningRoom.getRoomName()) {
                found = diningRoom;
            }
        }
        return found;
    }

    public void checkInGuests(int roomNumber, ArrayList<Guest> guests1, int nightsBooked) {
        Bedroom bedroom = getBedroomByNumber(roomNumber);
        if( guests1.size() <= bedroom.getCapacity() && !bedroom.isBooked()) {
            for (Guest guest: guests1) {
                bedroom.addGuest(guest);
            }
            bedroom.setNightsBooked(nightsBooked);
        }
    }

    public void checkOutGuests(int roomNumber, ArrayList<Guest> guests1) {
        Bedroom bedroom = getBedroomByNumber(roomNumber);
        if(bedroom.getGuests().containsAll(guests1) && guests1.containsAll(bedroom.getGuests())){
            for (Guest guest: guests1) {
                bedroom.getGuests().remove(guest);
            }
            bedroom.setNightsBooked(0);
        }
    }

    public ArrayList<Guest> getGuests(int roomNumber) {
        Bedroom bedroom = getBedroomByNumber(roomNumber);
        return bedroom.getGuests();
    }

    public void addConferenceBooking(String roomName, ArrayList<Guest> guests1) {
        ConferenceRoom conferenceRoom = getConferenceRoomByName(roomName);
        if(!conferenceRoom.isBooked() && guests1.size() <= conferenceRoom.getCapacity()) {
            conferenceRoom.addGuests(guests1);
        }
    }

    public ArrayList<Guest> getGuestsFromConferenceRoom(String roomName) {
        ConferenceRoom conferenceRoom = getConferenceRoomByName(roomName);
        return conferenceRoom.getGuests();
    }

    public void addMealBooking(String roomName, MealBooking mealBooking) {
        DiningRoom diningRoom = getDiningRoomByName(roomName);
        if(diningRoom.getGuests().size() + mealBooking.getGuestsFromBooking().size() <= diningRoom.getCapacity()) {
            diningRoom.addBooking(mealBooking);
        }
    }

    public ArrayList<Guest> getGuestsFromDiningRoom(String roomName) {
        DiningRoom diningRoom = getDiningRoomByName(roomName);
        return diningRoom.getGuests();
    }

//    Ask instructors - same function for dining and conference room - had to rename because both take in string but
// can't use same function for both as one works on dining rooms and one works on conference rooms.

    public ArrayList<Bedroom> getVacantRooms() {
        ArrayList<Bedroom> vacantBedrooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (!bedroom.isBooked()) {
                vacantBedrooms.add(bedroom);
            }
        }
        return vacantBedrooms;
    }

}
