import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShopTest {
    private Shop shop;
    private Flute flute;
    private Metronome metronome;

    @Before
    public void before() {
        shop = new Shop();
        flute = new Flute(1,120, 190,"flute", "silver", "metallic");
        metronome = new Metronome(2,4.50, 10.50, "metronome");
    }


    @Test
    public void canGetStockLevelsWhenEmpty() {
        assertEquals(new ArrayList<>(), shop.getStock());
    }

    @Test
    public void canAddToStock() {
        assertEquals(0,shop.getStock().size());
        assertFalse(shop.getStock().contains(flute));
        assertFalse(shop.getStock().contains(metronome));
        shop.addToStock(flute, 4);
        assertEquals(4, shop.getStock().size());
        assertTrue(shop.getStock().contains(flute));
        assertFalse(shop.getStock().contains(metronome));
        shop.addToStock(metronome, 10);
        assertEquals(14, shop.getStock().size());
        assertTrue(shop.getStock().contains(flute));
        assertTrue(shop.getStock().contains(metronome));
    }

    @Test
    public void canCheckIfStockContainsID() {
        shop.addToStock(flute,4);
        assertTrue(shop.stockContainsID(1));
        assertFalse(shop.stockContainsID(2));
    }

    @Test
    public void canFindByID() {
        shop.addToStock(flute,4);
        shop.addToStock(metronome,5);
        assertEquals(flute, shop.findByID(1));
        assertEquals(metronome, shop.findByID(2));
    }

    @Test
    public void canRemoveFromStock() {
        shop.addToStock(flute,3);
        shop.addToStock(metronome,8);
        shop.removeFromStock(flute,2);
        assertEquals(9, shop.getStock().size());
        shop.removeFromStock(flute,2);
        assertEquals(8, shop.getStock().size());
    }

    @Test
    public void canGetTotalPotentialProfit() {
        shop.addToStock(flute, 4);
        shop.addToStock(metronome,8);
        assertEquals(328, shop.totalPotentialProfit(), 0.01);
    }
}
