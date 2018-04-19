public class BasicPizza implements IPizza {

    double cost;
    String ingredients;
    String name;

    public BasicPizza(String name) {
        this.name = name;
        this.cost = 6.00;
        this.ingredients = "Tomato, cheese";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getIngredients() {
        return this.ingredients;
    }
}
