/**
 * Created by yangge on 1/27/2016.
 */
public class CaliforniaStyleVeggiePizza extends Pizza {
    public CaliforniaStyleVeggiePizza() {
        name = "California Style Sauce and Veggie Pizza";
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
