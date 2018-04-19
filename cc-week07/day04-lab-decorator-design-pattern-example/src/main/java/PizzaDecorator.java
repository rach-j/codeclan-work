public abstract class PizzaDecorator implements IPizza {

    IPizza decoratedPizza;

    public PizzaDecorator(IPizza pizza) {
        this.decoratedPizza = pizza;
    }

    @Override
    public String getName() {
        return this.decoratedPizza.getName();
    }

    @Override
    public double getCost() {
        return this.decoratedPizza.getCost();
    }

    @Override
    public String getIngredients() {
        return this.decoratedPizza.getIngredients();
    }
}
