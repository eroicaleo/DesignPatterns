package com.company;

/**
 * Created by yangge on 12/28/2015.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardBuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
