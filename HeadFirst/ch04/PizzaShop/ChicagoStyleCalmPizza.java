/**
 * Created by yangge on 1/26/2016.
 */
public class ChicagoStyleCalmPizza extends Pizza {
    public ChicagoStyleCalmPizza() {
        name = "Chicago Style Sauce and Calm Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Calm");

    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into square slices");
    }
}
