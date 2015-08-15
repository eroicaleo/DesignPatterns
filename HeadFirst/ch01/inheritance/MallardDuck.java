public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Looks like a Mallard Duck!");
    }
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        d.swim();
        d.display();
        d.quack();
        d.fly();
    }
}
