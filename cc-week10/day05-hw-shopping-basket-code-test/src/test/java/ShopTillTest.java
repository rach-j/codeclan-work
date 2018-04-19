import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShopTillTest {
    private ShopTill shopTill;
    private ShoppingBasket shoppingBasket;
    private Item item1;
    private BogofItem item2, item3;
    private Customer customer1, customer2;

    @Before
    public void before() {
        shopTill = new ShopTill();
        item1 = new Item(1, "Diet Coke - 6 pack", 4.50);
        item2 = new BogofItem(2, "Original Sauce Bodywash - Mint", 2.50);
        item3 = new BogofItem(3, "Heinz Ketchup 500ml", 1.20);
        shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItemToBasket(item1);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.addItemToBasket(item3);
        customer1 = new Customer("Rachel", true);
        customer1.addItemToBasket(item1);
        customer1.addItemToBasket(item2);
        customer1.addItemToBasket(item2);
        customer1.addItemToBasket(item3);
        customer2 = new Customer("Max", false);
        customer2.addItemToBasket(item1);
        customer2.addItemToBasket(item2);
        customer2.addItemToBasket(item2);
        customer2.addItemToBasket(item3);
    }

    @Test
    public void canGetFrequencyOfBogofItems() {
        HashMap<Integer, Integer> bogofitemHashMap = shopTill.getFrequencyOfBogofItems(shoppingBasket);
        assertTrue(2 == bogofitemHashMap.size());
        assertTrue(2 == bogofitemHashMap.get(2));
        assertTrue(1 == bogofitemHashMap.get(3));
    }

    @Test
    public void canGetValueOfBogofItems() {
        assertEquals(3.70, shopTill.getValueOfBogofItems(shoppingBasket),0.01);
        shoppingBasket.addItemToBasket(item3);
        assertEquals(3.70, shopTill.getValueOfBogofItems(shoppingBasket),0.01);
        shoppingBasket.addItemToBasket(item2);
        assertEquals(6.20, shopTill.getValueOfBogofItems(shoppingBasket),0.01);
        shoppingBasket.addItemToBasket(item3);
        assertEquals(7.40, shopTill.getValueOfBogofItems(shoppingBasket),0.01);
        shoppingBasket.addItemToBasket(item1);
        assertEquals(7.40, shopTill.getValueOfBogofItems(shoppingBasket),0.01);
    }

    @Test
    public void canGetValueOfNonBogofItems() {
        assertEquals(4.5, shopTill.getValueOfNonBogofItems(shoppingBasket), 0.01);
        shoppingBasket.addItemToBasket(item1);
        assertEquals(9, shopTill.getValueOfNonBogofItems(shoppingBasket), 0.01);
    }

    @Test
    public void canGetTotalPriceOfShoppingBasketBeforeDiscount() {
        assertEquals(8.2, shopTill.getTotalPriceBeforeDiscounts(shoppingBasket), 0.01);
    }

    @Test
    public void canCalculateOver20Discount() {
        assertEquals(0, shopTill.calculateOver20Discount(shoppingBasket), 0.01);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.addItemToBasket(item2);
        shoppingBasket.addItemToBasket(item2);
        assertEquals(0, shopTill.calculateOver20Discount(shoppingBasket), 0.01);
        shoppingBasket.addItemToBasket(item1);
        shoppingBasket.addItemToBasket(item1);
        assertEquals(2.22,shopTill.calculateOver20Discount(shoppingBasket),0.01);
    }

    @Test
    public void canCalculateLoyaltyDiscount() {
        assertEquals(0.16, shopTill.calculateLoyaltyDiscount(customer1),0.01);
        assertEquals(0, shopTill.calculateLoyaltyDiscount(customer2),0.01);
        customer1.addItemToBasket(item1);
        customer1.addItemToBasket(item1);
        customer1.addItemToBasket(item1);
        customer1.addItemToBasket(item1);
        assertEquals(0.47, shopTill.calculateLoyaltyDiscount(customer1),0.01);
    }

    @Test
    public void canCalculateTotalPriceAfterDiscounts() {
        assertEquals(8.04, shopTill.getTotalPriceOfShoppingBasketAfterDiscounts(customer1), 0.01);
        assertEquals(8.20, shopTill.getTotalPriceOfShoppingBasketAfterDiscounts(customer2),0.01);
    }
}
