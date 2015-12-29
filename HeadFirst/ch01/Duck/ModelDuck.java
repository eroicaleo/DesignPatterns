package com.company;

/**
 * Created by yangge on 12/28/2015.
 */
public class ModelDuck extends Duck {
    ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I am a model duck!");
    }
}
