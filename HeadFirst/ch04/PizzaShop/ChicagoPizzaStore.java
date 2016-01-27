/**
 * Created by yangge on 1/26/2016.
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else if (type.equals("calm")) {
            return new ChicagoStyleCalmPizza();
        } else if (type.equals("veggie")){
            return new ChicagoStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
