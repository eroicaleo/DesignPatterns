<!-- TOC depth:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Chapter 01 Welcome to design patterns: Strategy Pattern](#chapter-01-welcome-to-design-patterns-strategy-pattern)
- [Chapter 02 Keeping your objects in the know: Observer Pattern.](#chapter-02-keeping-your-objects-in-the-know-observer-pattern)
- [Chapter 03 Decorating Objects: Decorator Pattern](#chapter-03-decorating-objects-decorator-pattern)
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

**_Observer Pattern_** *defines a one-to-many dependency so that when one object
changes state, all of its dependents are notified and updated automatically*.

Observer Pattern Class Diagram:
![Observer Pattern Class Diagram](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/ObserverPatternClassDiagram.png)

**The Power of Loose Coupling**

When two objects are loosely coupled, they can interact, but have very little
knowledge about each other. The Observer Pattern provides an object design where
subjects and observers are loosely coupled. Because:

* The only thing the subject knows about an observer is that it implements a
  certain interface. It doesn't need to know anything else about observers.
* We can add new observers at any time.
* We never need to modify subject to add new types of observers. All we have to
  do is to implement the Observer interface in the new observers and register as
  an observer.
* We can reuse subjects or observers independently of each other.
* Changes to either subject or an observer will not affect others. As long as the
  the objects still meet their obligations and implement their subject or observer
  interfaces.

**Design Principles** *: Strive for loosely coupled designs between objects and interact*.
Loosely coupled designs allow us to build flexible OO systems that can handle change
because they minimize the interdependency between objects.

WeatherData Observer Pattern Diagram:
![WeatherData Observer Pattern Diagram](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/WeatherStationDiagram.png)

**Java built-in observer pattern**

![Java built-in observer pattern](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/ObserverPatternJavaBuiltin.png)

Note that there are some difference between Java built-in Observer Pattern and
our implementation:

* We need to first call `setChanged()` before we call `notifyObservers()`.
    * Give us the flexibility to optimize notification. Sometimes we might not
      want to send notification too often, e.g. weather sensor is too sensitive.
      The dual function is called `clearChanged()`.
* There are two versions of `notifyObservers`:
    * `notifyObservers()`
    * `notifyObservers(Object arg)`
    * The one without arguments let the observers `pull` data from `Observable`. While
      the one with arguments `push` data to observers.
* The `update` method in the `Observer` interface has the following signature.
    * `update(Observable o, Object arg)`
* Our program cannot depend on the order of the `observers`.

**The dark side of `java.util.Observable`**

* `Observable` is a class, which means:
    * We have to *subclass* it, we can't add on the `Observable` behavior to an
      existing class that already extends another superclass.
    * We cannot create our own implementation, and cannot swap the `java.util`
      implementation for another (say, a multi-threaded implementation).
    * Question??? We can still override the method.
    * Violates our "program to interfaces not implementation".
* `Observable` protects crucial methods `setChanged`, which means:
    * We cannot create an instance of the `Observable` class and compose it with
      your own objects, we have to *subclass*.
    * Violates our "favor composition over inheritance".

**How Observer Pattern make use of principles**

* Identify the aspects of your application that vary and separate them from what
  stays the same
    * The thing changes in Observer Pattern is the state of subject and the type
      and number of observers. We can vary the observers.
* program to interfaces not implementation
    * Both subject and observers use interfaces. Subject keeps tracking objects
      implementing observer interface and observer register and get notified by
      subject interface.
* favor composition over inheritance
    * It composes any number of Observers with their subject.

# Chapter 03 Decorating Objects: Decorator Pattern

Once we know the techniques of decorating, we will be able to give our or someone
else's objects new responsibility without making any code changes to the underlying
class.

In the StarBuzz example, we do `cost` like the following, we will have some
problems:
* If the condiments price changes, we need to modify `Beverage` class.
* If we need to add new condiments, we have to modify `cost` method.
* If we have new beverage like `Tea`, it should not have `hasWhip()` method. It
  would be weird, it's not a green tea frapuccino.
* What if a customer wants double `Mocha`?

```java
public double cost(){
    double c = 0.0;
    if (hasMilk()) {
        c += milkCost;
    }
    if (hasSoy()) {
        c += soyCost;
    }
    if (hasMocha()) {
        c += mochaCost;
    }
    if (hasWhip()) {
        c += whipCost;
    }
    return c;
}
```

**Design Principle**: *Classes should be open for extension, but closed for
modification*.

"Code should be closed (to change) like lotus flower in the evening, yet open (
to extension) like the lotus flower in the morning".

While it seems like a contradiction, there are techniques for allowing code to be
extended without modification. Be careful when choosing these areas of code that
need to extended. Applying Open-Close Principle EVERYWHERE is wasteful, unnecessary,
and can lead to complex, hard to understand code.

**Decorator Pattern**: *attaches additional responsibility to an object dynamically
. Decorators provide a flexible alternative to subclassing for extending functionality.*

Here are the class diagram for decorator pattern and how it gets applied on the
beverage problem:

![Decorator Pattern Class Diagram](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/DecoratorPatternClassDiagram.png)

![Decorator Pattern Beverage](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/DecoratorPatternBeverage.png)

Note that although `CondimentDecorator` inherit the `Beverage` class, we are using
inheritance to achieve *type matching* not to get *behavior*. We are using composition one
level after another, so we need to type matching. The new behavior comes in through
the composition of decorators with the base components as well as other decorators.
Because we use composition, we get a whole lot more flexibility about mix and match
condiments and beverages.

**`java.io` is a real world decorator**

Here is part of the class diagram for `java.io` library.

![Java IO Class Diagram](https://github.com/eroicaleo/DesignPatterns/blob/master/HeadFirst/JavaIOClassDiagram.png)

The diagram shows the downside of decorator pattern: results in too many small
classes that can be overwhelming to developers trying to use the Decorator-based
API.
