import java.util.HashMap;

public class ShopTill {

    public ShopTill() {

    }

    public HashMap<Integer, Integer> getFrequencyOfBogofItems(ShoppingBasket shoppingBasket) {
        HashMap<Integer, Integer> bogofItemHashMap = new HashMap<>();
        for (Item item : shoppingBasket.getItemsInBasket()) {
            if (item.getBogofStatus()) {
                bogofItemHashMap.put(item.getId(), 0);
            }
        }
//        Initializes HashMap with correct number of key, value pairs
        for (Item item : shoppingBasket.getItemsInBasket()) {
            if (item.getBogofStatus()) {
                bogofItemHashMap.put(item.getId(), bogofItemHashMap.get(item.getId()) + 1);
            }
        }
//        Populates values of HashMap
        return bogofItemHashMap;
    }

    public double getValueOfBogofItems(ShoppingBasket shoppingBasket) {
        HashMap<Integer, Integer> bogofItemHashMap = getFrequencyOfBogofItems(shoppingBasket);
        double total = 0;
        for (Integer id: bogofItemHashMap.keySet()) {
            double priceOfItem = shoppingBasket.findById(id).getPrice();
            double numberToChargeFor = Math.ceil(bogofItemHashMap.get(id)/2.0);
            total += priceOfItem * numberToChargeFor;
        }
        return total;
    }

    public double getValueOfNonBogofItems(ShoppingBasket shoppingBasket) {
        double total = 0;
        for (Item item: shoppingBasket.getItemsInBasket()) {
            if(!item.getBogofStatus()) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public double getTotalPriceBeforeDiscounts(ShoppingBasket shoppingBasket) {
        double total = getValueOfBogofItems(shoppingBasket) + getValueOfNonBogofItems(shoppingBasket);
        return total;
    }

    public double calculateOver20Discount(ShoppingBasket shoppingBasket) {
        if(getTotalPriceBeforeDiscounts(shoppingBasket) <= 20) {
            return 0;
            }
        return getTotalPriceBeforeDiscounts(shoppingBasket) * 0.1;
        }

    public double calculateLoyaltyDiscount(Customer customer) {
        if (customer.hasALoyaltyCard()) {
            double totalBeforeDiscount = getTotalPriceBeforeDiscounts(customer.getCustomerShoppingBasket());
            double over20Discount = calculateOver20Discount(customer.getCustomerShoppingBasket());
            return (totalBeforeDiscount - over20Discount) * 0.02;
            }
        return 0;
        }

    public double getTotalPriceOfShoppingBasketAfterDiscounts(Customer customer) {
        double totalBeforeDiscount = getTotalPriceBeforeDiscounts(customer.getCustomerShoppingBasket());
        double over20Discount = calculateOver20Discount(customer.getCustomerShoppingBasket());
        double loyaltyDiscount = calculateLoyaltyDiscount(customer);

        return (totalBeforeDiscount - over20Discount - loyaltyDiscount);

    }

}