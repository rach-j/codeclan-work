public class OrderPizza {

    public static void printInfo(IPizza pizza) {
        System.out.println("Order: " + pizza.getName() + "; Cost: " + pizza.getCost() + "; Ingredients: " + pizza.getIngredients());
    }

    public static void main(String[] args) {
        IPizza pizza = new BasicPizza("pizza1");
        printInfo(pizza);

        pizza = new Pepperoni(pizza);
        printInfo(pizza);

        pizza = new Pineapple(pizza);
        printInfo(pizza);



        IPizza pizza2 = new BasicPizza("pizza2");
        printInfo(pizza2);

        pizza2 = new Pepperoni(pizza2);
        printInfo(pizza2);

    }

}
