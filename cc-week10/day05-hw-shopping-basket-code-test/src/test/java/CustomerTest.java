import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    private Customer customer;
    private Item item1;
    private BogofItem item2;

    @Before
    public void before() {
        customer = new Customer("Rachel", true);
        item1 = new Item(1, "Diet Coke - 6 pack", 4.5);
        item2 = new BogofItem(2, "Original Sauce Bodywash - Mint", 2.50);
    }

    @Test
    public void canGetName() {
        assertEquals("Rachel", customer.getName());
    }

    @Test
    public void canCheckForLoyaltyCard() {
        assertTrue(customer.hasALoyaltyCard());
    }

    @Test
    public void canGetCustomerShoppingBasket() {
        assertEquals(0, customer.getCustomerShoppingBasket().getNumberOfItems());
    }

    @Test
    public void canAddItemToBasket() {
        customer.addItemToBasket(item1);
        assertEquals(1, customer.getCustomerShoppingBasket().getNumberOfItems());
        assertTrue(customer.getCustomerShoppingBasket().containsItem(item1));
    }

    @Test public void canRemoveItemFromBasket() {
        customer.addItemToBasket(item1);
        customer.removeItemFromBasket(item2);
        assertEquals(1, customer.getCustomerShoppingBasket().getNumberOfItems());
        assertTrue(customer.getCustomerShoppingBasket().containsItem(item1));
        customer.removeItemFromBasket(item1);
        assertEquals(0, customer.getCustomerShoppingBasket().getNumberOfItems());
        customer.addItemToBasket(item2);
        customer.removeItemFromBasket(item2);
        assertEquals(0, customer.getCustomerShoppingBasket().getNumberOfItems());
    }

    @Test public void canEmptyBasket() {
        customer.addItemToBasket(item1);
        customer.addItemToBasket(item2);
        customer.emptyBasket();
        assertEquals(0, customer.getCustomerShoppingBasket().getNumberOfItems());
    }
}
