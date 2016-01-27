/**
 * Created by yangge on 1/26/2016.
 */
public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        name = "Chicago Style Sauce and Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Veggie");

    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into square slices");
    }
}
