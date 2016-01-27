import java.util.ArrayList;

/**
 * Created by yangge on 1/17/2016.
 */
public class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public Pizza() {
    }

    public void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            String s =  toppings.get(i);
            System.out.println(s);
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place Pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
