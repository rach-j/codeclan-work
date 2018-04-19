public class BogofItem extends Item {
    private boolean bogofStatus;

    public BogofItem(int id, String name, double price) {
        super(id, name, price);
        this.bogofStatus = true;
    }

    public boolean getBogofStatus() {
        return this.bogofStatus;

    }
}

// Set up a new class for BogofItems (as a subclass of Item) with a default bogof status so that you can't have two
// instances of Item with the same id where one is on a bogof offer and the other isn't.

