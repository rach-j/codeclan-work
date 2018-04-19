public class Driver {

    String name;
    IDriveable vehicle;

    public Driver(String name, IDriveable vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return this.name;
    }

    public IDriveable getVehicle() {
        return this.vehicle;
    }

    public int driveDistance(int distance) {
        return this.vehicle.driveDistance(distance);
    }

    public void setVehicle(IDriveable vehicle) {
        this.vehicle = vehicle;
    }
}
