/**
 * Created by yangge on 1/27/2016.
 */
public class CaliforniaStyleCalmPizza extends Pizza {
    public CaliforniaStyleCalmPizza() {
        name = "California Style Sauce and Calm Pizza";
        dough = "Thin Dumpling Dough";
        sauce = "Hot and Spicy and Vinegar";

        toppings.add("Sausage");
        toppings.add("Ham");
        toppings.add("Pork Kidney");

    }

    @Override
    public void bake() {
        System.out.println("In boiling water for 3 minutes");
    }
}
