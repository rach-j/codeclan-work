package Hotel.Room;

import Hotel.Guest;

import java.util.ArrayList;

public class ConferenceRoom extends Room {

    private String roomName;
    private int chargeOutRate;

    public ConferenceRoom(RoomType roomType, int capacity, String roomName) {
        super(roomType, capacity);
        this.roomName = roomName;
        this.chargeOutRate = 450;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getRate() {
        return this.chargeOutRate;
    }

    public boolean isBooked() {
        if (getGuests().size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void addGuests(ArrayList<Guest> guests) {
        for (Guest guest: guests) {
            getGuests().add(guest);
        }
    }
}
