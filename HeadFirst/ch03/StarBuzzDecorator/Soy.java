/**
 * Created by yangge on 1/7/2016.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (getSize() == Size.TALL) {
            cost += 0.1;
        } else if (getSize() == Size.GRANDE) {
            cost += 0.15;
        } else if (getSize() == Size.VENTI) {
            cost += 0.20;
        }
        return cost;
    }
}
