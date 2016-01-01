<!-- TOC depth:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Chapter 01 Welcome to design patterns: Strategy Pattern](#chapter-01-welcome-to-design-patterns-strategy-pattern)
- [Chapter 02 Keeping your objects in the know: Observer Pattern.](#chapter-02-keeping-your-objects-in-the-know-observer-pattern)
<!-- /TOC -->

# Chapter 01 Welcome to design patterns: Strategy Pattern

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

**Integrating the duck behavior**

The key is that a Duck will **delegate** its flying and quacking behavior, instead
of using quacking and flying methods defined in the `Duck` class.

```java
public class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All ducks swim, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}

public class ModelDuck extends Duck {
    ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I am a model duck!");
    }
}
```

The only problem with our current implementation is that: we should not programming
to an interface, but we are doing in that constructor, we are making a new instance
of a concrete `Quack` implementation class.

We are doing a poor job of initializing the instance variables in a flexible way.
We will fix it later using more patterns.

**The big pictures on encapsulated behaviors**

Instead of thinking of the duck behaviors as *a set of behaviors*, we'll start
think of them as a *family of algorithms*. in the SimUDuck design, the algorithms
represent things a duck would do (different ways of quacking or flying).

**Design Principles:** *Favor composition over inheritance*.

Creating systems using composition gives you a lot more flexibility. Not only
does it let you encapsulate a family of algorithms into their own set of classes,
but it also allows you to **_change behavior at runtime_**.

**Strategy Pattern**: defines a family of algorithms, encapsulate each one, and
makes them interchangeable. Strategy lets the algorithm vary independently from
clients that use it.

**How to use design pattern**: We use libraries, frameworks, APIs, we can just
pick and choose components and plug them in. But they don't help us structure our
own application in ways that are easier to understand, more maintainable and flexible.
That's where design pattern comes in.

# Chapter 02 Keeping your objects in the know: Observer Pattern.

Observer Pattern keeps your objects in the know when something they might care
about happens. Objects can even decide at runtime whether they want to be kept
informed. It's one of the most heavily used pattern in JDK.

**Weather Monitoring Application**

Three players in this application:

* Weather Station: physical devices acquire actual weather data
* `WeatherData` object: tracks data coming in from weather station and updates
  display.
* display: show users current weather conditions.

Our job is to implement `measurementsChanged()` so that it updates the three
displays for current conditions, weather stats, and forecast.

The system have to be expandable: other developers can create new custom display
elements and users can add or remove as many display elements as they want to the
application.

Our first implementation below has the following problem:

* coding to concrete implementation, not interfaces.
* For every new display element we need to alter the code.
* We have no way to add or remove display elements at runtime.
* The display elements don't implement a common interface.
* We haven't encapsulated the part that changes.
* We are violating encapsulation of `WeatherData` class.

```java
public class WeatherData {

    private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
    private StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
    private ForecastDisplay forecastDisplay = new ForecastDisplay();

    public void measurementsChanged() {
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();

        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }

}
```

**Observer Pattern**

Observer pattern is pretty much like the newspaper subscription. We call the
newspaper publisher `Subject`, and subscriber `Observer`.
