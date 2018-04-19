import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity){
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();

    }

    public int numberOfPassengers() {
        return passengers.size();
    }

    public void pickup(BusStop busstop, Person person) {
        busstop.removePassengerFromStop(person);
        addPassenger(person);
    }

    public void addPassenger(Person person) {
        if (numberOfPassengers() < capacity)
        { passengers.add(person);}
        else {}
    }

    public void removePassenger(Person person) {
        passengers.remove(0);
    }
}
