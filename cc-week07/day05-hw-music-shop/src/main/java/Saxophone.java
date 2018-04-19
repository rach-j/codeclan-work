import Enums.InstrumentType;

public class Saxophone extends Instrument {

    public Saxophone(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour) {
        super(uniqueID, buyPrice, sellPrice, description, material, colour, InstrumentType.WOODWIND);
    }

    @Override
    public String playSound() {
        return "Doo bee doo bee doo";
    }
}
