/**
 * Created by yangge on 1/6/2016.
 */
public class Beverage {
    String description;
    boolean milk;
    boolean soy;
    boolean mocha;
    boolean whip;

    public Beverage() {
        this.description = "";
        this.milk = false;
        this.soy = false;
        this.mocha = false;
        this.whip = false;
    }

    public boolean hasMilk() {
        return milk;
    }

    public boolean hasSoy() {
        return soy;
    }

    public boolean hasMocha() {
        return mocha;
    }

    public boolean hasWhip() {
        return whip;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }

    public double cost(){
        double c = 0.0;
        if (hasMilk()) {
            c += 1.0;
        }
        if (hasSoy()) {
            c += 2.0;
        }
        if (hasMocha()) {
            c += 3.0;
        }
        if (hasWhip()) {
            c += 4.0;
        }
        return c;
    }
}
