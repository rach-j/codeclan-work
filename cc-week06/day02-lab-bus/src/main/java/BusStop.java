import java.util.ArrayList;

public class BusStop {
    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name){
        this.name = name;
        this.queue = new ArrayList<>();

    }

    public int numberOfPassengers() {
        return queue.size();
    }

    public void addPassengerToStop(Person person) {
        queue.add(person);
    }

    public void removePassengerFromStop(Person person) {
         queue.remove(person);
    }
}
