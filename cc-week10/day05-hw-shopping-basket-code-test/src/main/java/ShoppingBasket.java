import java.util.ArrayList;

public class ShoppingBasket {
    private ArrayList<Item> itemsInBasket;

    public ShoppingBasket() {
        this.itemsInBasket = new ArrayList<>();
    }

    public ArrayList<Item> getItemsInBasket() {
        return itemsInBasket;
    }

    public void addItemToBasket(Item item) {
        itemsInBasket.add(item);
    }

    public int getNumberOfItems() {
      return itemsInBasket.size();
    }

    public boolean containsItem(Item itemToAdd) {
        for (Item item: itemsInBasket) {
            if (item.getId() == itemToAdd.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeItemFromBasket(Item itemToRemove) {
        if (containsItem(itemToRemove)) {
                itemsInBasket.remove(itemToRemove);
            }
        }

    public void emptyBasket() {
        itemsInBasket = new ArrayList<>();
    }

    public Item findById(int id) {
        for(Item item: itemsInBasket) {
            if( item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
