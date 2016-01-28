/**
 * Created by yangge on 1/27/2016.
 */
public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CaliforniaStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new CaliforniaStylePepperoniPizza();
        } else if (type.equals("calm")) {
            return new CaliforniaStyleCalmPizza();
        } else if (type.equals("veggie")){
            return new CaliforniaStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
