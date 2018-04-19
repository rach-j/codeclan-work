package Hotel.Room;

public enum BedroomType {
    SINGLE(90),
    DOUBLE(150),
    FAMILY(185);

    private int chargeOutRate;

    BedroomType(int chargeOutRate) {
        this.chargeOutRate = chargeOutRate;
    }

    public int getChargeOutRate() {
        return chargeOutRate;
    }
}
