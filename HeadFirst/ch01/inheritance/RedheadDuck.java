public class RedheadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Looks like a Redhead Duck!");
    }
    public static void main(String[] args) {
        Duck d = new RedheadDuck();
        d.swim();
        d.display();
        d.quack();
        d.fly();
    }
}
