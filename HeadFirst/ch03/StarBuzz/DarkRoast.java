/**
 * Created by yangge on 1/6/2016.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Most Excellent Dark Roast";
    }

    public double cost() {
        double c = 5.0;

        c += super.cost();

        return c;
    }
}
