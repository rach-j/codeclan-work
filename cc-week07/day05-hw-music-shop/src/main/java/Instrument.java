import Enums.InstrumentType;
import Interfaces.IPlay;

public abstract class Instrument extends Stock implements IPlay {

    protected String material;
    protected String colour;
    protected InstrumentType instrumentType;

    public Instrument(int uniqueID, double buyPrice, double sellPrice, String description, String material, String colour, InstrumentType instrumentType) {
        super(uniqueID, buyPrice, sellPrice, description);
        this.material = material;
        this.colour = colour;
        this.instrumentType = instrumentType;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getColour() {
        return this.colour;
    }

    public InstrumentType getType() {
        return this.instrumentType;
    }

    public abstract String playSound();

}
