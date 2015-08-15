public class Duck {
    public void swim() {
        System.out.println("Duck is swimming!");
    }
    public void display() {
        System.out.println("Looks like a Duck");
    }
    public void quack() {
        System.out.println("Quack Quack Quack!");
    }
    public void fly() {
        System.out.println("Duck is flying!");
    }
    public static void main(String[] args) {
        Duck d = new Duck();
        d.swim();
        d.display();
        d.quack();
        d.fly();
    }
}
