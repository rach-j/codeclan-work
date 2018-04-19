public class GuitarStrings extends Stock {

    private int stringsInPacket;

    public GuitarStrings(int uniqueID, double buyPrice, double sellPrice, String description, int stringsInPacket) {
        super(uniqueID, buyPrice, sellPrice, description);
        this.stringsInPacket = stringsInPacket;
    }

    public int getNumberOfStringsInPacket() {
        return this.stringsInPacket;
    }
}
