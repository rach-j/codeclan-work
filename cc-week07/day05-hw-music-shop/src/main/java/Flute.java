import Enums.InstrumentType;

public class Flute extends Instrument {

    public Flute(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour) {
        super(uniqueID, buyPrice, sellPrice, description, material, colour, InstrumentType.WOODWIND);
    }

    @Override
    public String playSound() {
        return "Toot toot!";
    }
}

