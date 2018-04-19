public class Customer {
    private String name;
    private boolean hasALoyaltyCard;
    private ShoppingBasket customerShoppingBasket;

    public Customer(String name, boolean hasALoyaltyCard) {
        this.name = name;
        this.hasALoyaltyCard = hasALoyaltyCard;
        this.customerShoppingBasket = new ShoppingBasket();
    }

    public String getName() {
        return this.name;
    }

    public boolean hasALoyaltyCard() {
        return this.hasALoyaltyCard;
    }

    public ShoppingBasket getCustomerShoppingBasket() {
        return this.customerShoppingBasket;
    }

    public void addItemToBasket(Item item) {
        customerShoppingBasket.addItemToBasket(item);
    }

    public void removeItemFromBasket(Item item) {
        customerShoppingBasket.removeItemFromBasket(item);
    }

    public void emptyBasket() {
        customerShoppingBasket.emptyBasket();
    }
}
