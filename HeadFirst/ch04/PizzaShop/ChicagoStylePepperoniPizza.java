/**
 * Created by yangge on 1/26/2016.
 */
public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Sauce and Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Pepperoni");

    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into square slices");
    }
}
