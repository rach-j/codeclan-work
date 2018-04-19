import Enums.InstrumentType;

public class DrumKit extends Instrument {

    private int numberOfCymbals;
    private int numberOfDrums;

    public DrumKit(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour, int numberOfCymbals, int numberOfDrums) {
        super(uniqueID, buyPrice, sellPrice, description, material, colour, InstrumentType.PERCUSSION);
        this.numberOfCymbals = numberOfCymbals;
        this.numberOfDrums = numberOfDrums;
    }

    @Override
    public String playSound() {
        return "Bang bang, crash!";
    }

    public int getNumberOfCymbals() {
        return this.numberOfCymbals;
    }

    public int getNumberOfDrums() {
        return this.numberOfDrums;
    }


}
