public class DodgemCar extends Vehicle {

        int numberOfSeats;

    public DodgemCar(double averageSpeed, int numberOfSeats) {
        super(averageSpeed);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
