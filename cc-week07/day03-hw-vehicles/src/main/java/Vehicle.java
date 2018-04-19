public abstract class Vehicle implements IDriveable {

    double averageSpeed;

    public Vehicle(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getAverageSpeed() {
        return this.averageSpeed;
    }

    @Override
    public int driveDistance(int distance) {
        return (int) (distance / getAverageSpeed());
    }
}
