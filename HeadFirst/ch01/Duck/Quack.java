package com.company;

/**
 * Created by yangge on 12/26/2015.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I am quacking");
    }
}
