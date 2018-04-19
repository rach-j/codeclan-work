public class Pepperoni extends PizzaDecorator {

    public Pepperoni(IPizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.20;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", pepperoni";
    }

}
