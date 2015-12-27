
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

**Design Principle** *: Program to an interface, not an implementation.*

We'll use an interface to represent each behavior - for instance, `FlyBehaviour`
and `QuackBehaviour` - and each implementation of a *behavior* will implement one
of those interfaces.

So this time it won't be `Duck` to implement the flying and quacking interfaces.
Instead, we'll make a set of classes whose entire reason of living is to represent
behavior (e.g. squeaking), and it's the *behavior* class, rather than the `Duck`
class, that will implement the behavior interfaces.

This is in contrast to the way we were doing things before, where a behavior either
came from a concrete implementation in the super class `Duck`, or by providing a
specialized implementation in the subclass itself. In both cases, we were relying
on *implementation*. We were locked into using that specific implementation and
there was no room for changing out the behavior.

With our new design, the `Duck` subclasses will use a behavior represented by an
*interface*, (`FlyBehaviour` and `QuackBehaviour`), so that the actual `implementation`
of the behavior (in other words, the specific concrete behavior coded in the class
that implements the `FlyBehaviour` and `QuackBehaviour`) won't be locked into the
`Duck` subclass.
