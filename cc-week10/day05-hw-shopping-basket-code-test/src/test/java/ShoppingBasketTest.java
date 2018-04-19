import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingBasketTest {
    private ShoppingBasket shoppingBasket;
    private Item item1;
    private BogofItem item2;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        item1 = new Item(1,"Diet Coke - 6 pack", 4.50);
        item2 = new BogofItem(2, "Original Sauce Bodywash - Mint", 2.50);
    }

    @Test
    public void canGetItemsinBasket() {
        assertEquals(new ArrayList<>(), shoppingBasket.getItemsInBasket());
    }

    @Test
    public void canAddItemsToBasket() {
        shoppingBasket.addItemToBasket(item1);
        assertEquals(1, shoppingBasket.getNumberOfItems());
        assertTrue(shoppingBasket.containsItem(item1));
        shoppingBasket.addItemToBasket(item2);
        assertEquals(2, shoppingBasket.getNumberOfItems());
        assertTrue(shoppingBasket.containsItem(item2));
    }

    @Test
    public void canRemoveItemFromBasket() {
        shoppingBasket.addItemToBasket(item1);
        shoppingBasket.removeItemFromBasket(item2);
        assertEquals(1, shoppingBasket.getNumberOfItems());
        assertTrue(shoppingBasket.containsItem(item1));
        shoppingBasket.removeItemFromBasket(item1);
        assertEquals(0, shoppingBasket.getNumberOfItems());
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.removeItemFromBasket(item2);
        assertEquals(0, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void canEmptyBasket() {
        shoppingBasket.addItemToBasket(item1);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.emptyBasket();
        assertEquals(0, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void canFindItemById() {
        shoppingBasket.addItemToBasket(item1);
        assertEquals(null, shoppingBasket.findById(2));
        assertEquals(item1, shoppingBasket.findById(1));
    }


}
