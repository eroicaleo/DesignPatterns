public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Looks like a Rubber Duck!");
    }
    @Override
    public void quack() {
        System.out.println("Squeak Squeak Squeak!");
    }
    public static void main(String[] args) {
        Duck d = new RubberDuck();
        d.swim();
        d.display();
        d.quack();
        d.fly();
    }
}
