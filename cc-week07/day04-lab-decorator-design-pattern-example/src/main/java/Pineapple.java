public class Pineapple extends PizzaDecorator {

        public Pineapple(IPizza pizza) {
            super(pizza);
        }

        @Override
        public double getCost() {
            return super.getCost() + -1.00;
        }

        @Override
        public String getIngredients() {
            return super.getIngredients() + ", pineapple";
        }

}
