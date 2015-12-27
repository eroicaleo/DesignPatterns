/**
 * Created by yangge on 12/22/2015.
 */

public class Duck {
    public void swim() {
        System.out.println("Duck is swimming!");
    }
    public void display() {
        System.out.println("Looks like a generic Duck");
    }

    public static void main(String[] args) {
        Duck d = new Duck();
        d.swim();
        d.display();
        System.out.println("Hello Duck");
    }
}
