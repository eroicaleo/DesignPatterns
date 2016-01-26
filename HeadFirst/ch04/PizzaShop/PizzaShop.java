/**
 * Created by yangge on 1/17/2016.
 */
public class PizzaShop {
    SimplePizzaFactory factory;

    public PizzaShop(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public

    Pizza orderPizza(String type) {

        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
