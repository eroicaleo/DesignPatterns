/**
 * Created by yangge on 1/28/2016.
 */
public class VeryDependentPizzaStore {
    Pizza createPizza(String style, String type) {
        Pizza pizza = null;

        if (style == "NY") {
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
        } else if (style == "Chicago") {
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
        } else {
            System.out.printf("Error: invalid type of pizza!");
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
