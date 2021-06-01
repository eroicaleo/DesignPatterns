# Ch01 Basics of OOP

## UML example

<img src="./images/UML.png" style="zoom:50%;" />

* Data stored inside the object’s fields is often referenced
  as state, and all the object’s methods define its behavior.

<img src="./images/ch01UML02.png" style="zoom:50%;" />

# Ch02 Pillars of OOP

Four pillars:

* Abstraction
* Encapsulation
* Polymorphism
* Inheritance

## Abstraction

Your objects only model attributes and behaviors of
real objects in a specific context, ignoring the rest.

For example, an Airplane class could probably exist in both
a flight simulator and a flight booking application. But in the
former case, it would hold details related to the actual flight,
whereas in the latter class you would care only about the seat
map and which seats are available.

Abstraction is a model of a real-world object or phenomenon, limited to a specific context, which represents all details relevant to this context with high accuracy and omits all the rest.

所谓的抽象化过程，就是把事物的一方面特征，你所关心的特征拿出来，精确描述。然后忽略其余细节。

<img src="./images/Airplane.png" style="zoom:50%;" />

## Encapsulation

To drive a car, you only have very simple interface:

* a start switch
* a steering wheel
* some pedals

This illustrates how each object has an ***interface***—a public part of an object, open to interactions
with other objects.

***Encapsulation*** is the ability of an object to hide parts of its state and behaviors from other objects, exposing only a limited interface to the rest of the program.

In modern PL, the mechanism of interface (usually declared with `interface` or `protocol` keywords) lets you define contracts of interaction between objects. That's one of the reasons why the interface only cares about behaviours of objects, and why you can't declare a field in an interface.

Example: `Airport` class can only work with objects that implements `FlyingTransport` interface.

```java
public interface FlyingTransport {
    void fly(String origin, String destination, Integer passengers);
}

public class Airport {
  void accept(FlyingTransport vehicle);
}

public class Helicopter implements FlyingTransport {
  ...
}

public class Airplane implements FlyingTransport {
  ...
}
```

<img src="./images/Airport.png" style="zoom:50%;" />

## Inheritance

***Inheritance*** is the ability to build new classes on top of existing ones. The main benefit of inheritance is code reuse.

The consequence of using inheritance is that subclasses have the same interface as their parent class.

* You can’t hide a method in a subclass if it was declared in the superclass. 
* You must also implement all abstract methods, even if they don’t make sense for your subclass.

这是继承不太flexible的地方。

<img src="./images/ch02UMLInheritance.png" style="zoom:50%;" />



In most PL, a subclass can only extend one super class. Any class can implement several interfaces at the same time.

## Polymorphism

<img src="./images/ch02polymorphism.png" style="zoom:50%;" />

想象我们从一个袋子里闭着眼睛拿动物，我们把动物弄出声音，他们就会发出各自的声音。我们就知道是猫还是狗了。



```java
bag = [new Cat(), new Dog()]
foreach (Animal a : bag)
  a.makeSound()
```



***Polymorphism*** is the ability of a program to detect the real class of an object and call its implementation even when its real type is unknown in the current context.

You can also think of polymorphism as the ability of an object to “pretend” to be something else, usually a class it extends or an interface it implements. In our example, the dogs and cats in the bag were pretending to be generic animals.

# Ch03 Relations Between Objects

Pg 20

如题，这章讲述class之间的其他关系。

## Association

***Association***: is a type of relationship in which one object uses or interacts with another.

<img src="./images/ch03association.png" style="zoom:50%;" />

The link between the 2 class is ***always*** there. It is similar to a field in a class, but doesn't always have to be. It can be a method that returns a object, e.g. an order have a method to return its customer.

注意这里的重点是***link is always there***.

## Dependency

***Dependency***: a weaker variant of association that usually implies that there’s no permanent link between objects.

Dependency typically (but not always) implies that an object accepts another object as a method parameter, instantiates, or uses another object.

比association宽泛，比如在一个method里作为参数。或者在一个method里，instantiates另一个类。这里method结束了，另一个class object就没有了。

Here’s how you can spot a dependency between classes: **a dependency exists between two classes if changes to the definition of one class result in modifications in another class.**

<img src="./images/ch03dependency.png" style="zoom:50%;" />

## Composition

***Composition***: "whole-part" relationship between two objects, one of which is composed of one or more instances of the other.

The distinction between this relation and others is that the component can only exist as a part of the container.

如下图，没有学校就没有系。

<img src="./images/ch03composition.png" style="zoom:50%;" />

## Aggregation

***Aggregation***: One object merely contains a reference to another. The container doesn’t control the life cycle of the component. The component can exist without the container and can be linked to several containers at the same time.

没有了系，老师这个类还可以存在。可以换一个学校等等。

<img src="./images/ch03aggregation.png" style="zoom:50%;" />

# Ch04 What's a Design Pattern

pg 25

***Design patterns***: common solutions to typical problems. They are customizable blueprints to solve recurring design problems in your code.

是一个像设计蓝图一样的东西。

You cannot use it the way you use off-the-shelf functions and libraries. They are a general concept for solving a particular problem. 

Pattern and Algorithm: both are typical solutions for some known problems.

* Algorithm: low level, a clear set of actions that can achieve some goal.
  * More like recipe, clear steps to achieve a goal.
* Pattern: high level description of a solution.
  * More like blueprint: what the result and its features are, but the exact order of information is up to you.

## What does the pattern consist of?

***Intent***: of the pattern briefly describes both the problem and the solution.

***Motivation***: further explains the problem and the solution the pattern makes possible.

***Structure*** of classes shows each part of the pattern and how they are related.

***Code example*** in one of the popular programming languages makes it easier to grasp the idea behind the pattern.

## Classification of patterns

Design patterns differ by their complexity, level of detail and scale of applicability to the entire system being designed.

Road construction analogy, to make a safe intersection:

* simple traffic lights
* multilevel Interchange, underground passages for pedestrians.

Low level patterns are called ***idioms***. Only to a single PL. 我们常说的pythonic way。

Most universal and high-level patterns are ***architectural patterns***.

***Creational patterns***: provide object creation mechanisms that increase flexibility and reuse of existing code.

***Structural patterns***: explain how to assemble objects and classes into larger structures, while keeping the structures flexible and efficient.

***Behavioral patterns***: take care of effective communication and the assignment of responsibilities between objects.

分别是object如何创建，如何放在一起，如果互动/各司其职。

# Ch05 Why Should I Learn Patterns?

pg 29

[TOC]

