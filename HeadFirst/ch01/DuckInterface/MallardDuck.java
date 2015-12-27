/**
 * Created by yangge on 12/22/2015.
 */
public class MallardDuck extends Duck implements Flyable {
    public void fly() {
        System.out.println("MallardDuck is flying!");
    }

    @Override
    public void display() {
        System.out.println("Looks like a Mallard Duck");
    }

    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();
        d.swim();
        d.display();
        d.fly();
    }

}
