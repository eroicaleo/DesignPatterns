/**
 * Created by yangge on 1/7/2016.
 */
public abstract class Beverage {
    String description = "Unknow Beverage";
    enum Size {TALL, GRANDE, VENTI};
    Size size;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
