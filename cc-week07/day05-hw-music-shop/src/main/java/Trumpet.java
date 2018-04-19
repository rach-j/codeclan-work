import Enums.InstrumentType;

public class Trumpet extends Instrument {

    public Trumpet(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour) {
        super(uniqueID, buyPrice, sellPrice, description, material, colour, InstrumentType.BRASS);
    }

    @Override
    public String playSound() {
        return "Parp parp!";
    }
}
