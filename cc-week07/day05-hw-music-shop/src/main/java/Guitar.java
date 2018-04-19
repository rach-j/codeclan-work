import Enums.GuitarType;
import Enums.InstrumentType;

public class Guitar extends Instrument {

    private GuitarType guitarType;
    private int numberOfStrings;

    public Guitar(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour, GuitarType guitarType, int numberOfStrings) {
        super(uniqueID, buyPrice, sellPrice, description, material, colour, InstrumentType.STRING);
        this.guitarType = guitarType;
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String playSound() {
        return "Strum strum";
    }

    public GuitarType getGuitarType() {
        return this.guitarType;
    }

    public int getNumberOfStrings() {
        return this.numberOfStrings;
    }
}
