package com.company;

/**
 * Created by yangge on 12/28/2015.
 */
public class MallardBuck extends Duck {
    MallardBuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I am a real Mallard Duck!");
    }
}
