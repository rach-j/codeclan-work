package Hotel.Room;

import Hotel.Guest;

import java.util.ArrayList;

public abstract class Room {

    private RoomType roomType;
    private int capacity;
    private ArrayList<Guest> guests;

    public Room(RoomType roomType, int capacity) {
        this.roomType = roomType;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public RoomType getType() {
        return this.roomType;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }
}
