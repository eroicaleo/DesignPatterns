/**
 * Created by yangge on 1/26/2016.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else if (type.equals("calm")) {
            return new NYStyleCalmPizza();
        } else if (type.equals("veggie")){
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
