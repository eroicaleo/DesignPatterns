/**
 * Created by yangge on 1/6/2016.
 */
public class StarBuzz {
    public static void main(String[] args) {
        Beverage b = new DarkRoast();
        b.setMilk(true);
        b.setWhip(true);
        System.out.printf("Your price for %s is %f", b.description, b.cost());
    }
}
