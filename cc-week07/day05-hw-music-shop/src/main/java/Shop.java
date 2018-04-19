import java.util.ArrayList;

public class Shop {

    private ArrayList<Stock> stock;

    public Shop() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Stock> getStock() {
        return this.stock;
    }

        public void addToStock(Stock stockItem, int quantity) {
            for (int i = 1; i <= quantity; i++) {
                this.stock.add(stockItem);
            }
        }

        public boolean stockContainsID(int id) {
            for (Stock item: this.stock) {
                if (item.getUniqueID() == id) {
                    return true;
                }
            }
            return false;
        }

        public Stock findByID(int id) {
            Stock found = null;
            for (Stock item: this.stock) {
                if (item.getUniqueID() == id) {
                    found = item;
                }
            }
            return found;
        }

        public void removeFromStock(Stock stockItem, int quantity) {
            for (int i = 1; i <= quantity; i++) {
                if (stockContainsID(stockItem.getUniqueID())) {
                    Stock itemToBeRemoved = findByID(stockItem.getUniqueID());
                    this.stock.remove(itemToBeRemoved);
                    }
            }
        }

// Assumes uniqueID is unique so two stock items will have the same ID if and only if all of their
// other attributes are the same

        public double totalPotentialProfit() {
            double total = 0;
            for (Stock item: this.stock) {
                total += item.markUp();
            }
            return total;
        }
}
