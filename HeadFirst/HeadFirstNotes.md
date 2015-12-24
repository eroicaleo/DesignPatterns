
# Chapter 01 Welcome to design patterns

The duck problem, inheritance is not a solution because some ducks don't fly,
some ducks even don't quack.

Interface example:

```java
interface Flyable {
    void fly();
}

public class MallardDuck extends Duck implements Flyable {
    public void fly() {
        System.out.println("MallardDuck is flying!");
    }

    @Override
    public void display() {
        System.out.println("Looks like a Mallard Duck");
    }
}

```

Interface is also not the solution because if we want to change the `fly()`
behavior, we are going to change the code in all 48 flying duck subclasses.

Software keeps changing or it dies.

So here is our first design principle: **_identify the aspects of your application
that vary and separate them from what stays the same_**.

Here is another way to think about this principle: **_take the parts that
vary and encapsulate them, so that later you can alter or extend the parts
that vary without affecting those that don't_**.

One example from my experience is that in the development of aventador VBS script,
I defined a `prbs_config` class. All the functions take an `prbs_config` as its
argument. So I can keep extending the `prbs_config` class and don't have to modify
the interface of those functions.
