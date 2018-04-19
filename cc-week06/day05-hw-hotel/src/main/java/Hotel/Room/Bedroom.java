package Hotel.Room;

import Hotel.Guest;

public class Bedroom extends Room {

    private BedroomType bedroomType;
    private int bedroomNumber;
    private int nightsBooked;


    public Bedroom(RoomType roomType, int capacity, BedroomType bedroomType, int bedroomNumber) {
        super(roomType, capacity);
        this.bedroomType = bedroomType;
        this.bedroomNumber = bedroomNumber;
        this.nightsBooked = 0;
    }


    public BedroomType getBedroomType() {
        return this.bedroomType;
    }

    public int getRoomRate() {
        return this.bedroomType.getChargeOutRate();
    }

    public int getRoomNumber() {
        return this.bedroomNumber;
    }

    public boolean isBooked() {
        if (getGuests().size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void addGuest(Guest guest) {
        getGuests().add(guest);
    }

    public void removeGuest(Guest guest) {
        if(getGuests().contains(guest)) {
            getGuests().remove(guest);
        }
    }

    public int getNightsBooked() {
        return this.nightsBooked;
    }

    public void setNightsBooked(int numberOfNights) {
        this.nightsBooked = numberOfNights;
    }
}
