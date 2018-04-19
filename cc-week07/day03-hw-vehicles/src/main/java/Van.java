public class Van extends Vehicle {

    String registrationPlate;

    public Van(double averageSpeed, String registrationPlate) {
        super(averageSpeed);
        this.registrationPlate = registrationPlate;
    }

    public String getRegistrationPlate() {
        return this.registrationPlate;
    }
}
