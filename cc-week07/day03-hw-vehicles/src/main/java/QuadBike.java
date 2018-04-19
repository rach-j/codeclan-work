public class QuadBike extends Vehicle {

    int engineCapacity;

    public QuadBike(double averageSpeed, int engineCapacity) {
        super(averageSpeed);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }
}
