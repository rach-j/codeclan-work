import Interfaces.ISell;

public abstract class Stock implements ISell {

    protected double buyPrice;
    protected double sellPrice;
    protected String description;
    private int uniqueID;

    public Stock(int uniqueID, double buyPrice, double sellPrice, String description) {
        this.uniqueID = uniqueID;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.description = description;
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }

    public double markUp() {
        return this.sellPrice - this.buyPrice;
    }

    public String getDescription() {
        return this.description;
    }
}
