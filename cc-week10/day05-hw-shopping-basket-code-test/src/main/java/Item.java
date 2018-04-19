public class Item {
    private int id;
    private String name;
    private double price;
    private boolean bogofStatus;

    public Item(int id, String name, double price) {
        this.id = id;
//        Code has been set up to assume that if two items have the same id then they are the same item.
        this.name = name;
        this.price = price;
        this.bogofStatus = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getBogofStatus() {
        return this.bogofStatus;

    }

}
