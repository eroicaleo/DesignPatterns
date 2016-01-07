import java.util.Observable;
import java.util.Observer;

/**
 * Created by yangge on 1/4/2016.
 */
public class HeatIndexDisplay implements Observer {
    private float temperature;
    private float humidity;
    private double heatindex;
    private Observable observable;

    public HeatIndexDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.temperature = ((WeatherData) o).getTemperature();
            this.humidity = ((WeatherData) o).getHumidity();
            this.heatindex = 16.923 + 1.85212 / 10 * this.temperature + 5.39*this.humidity;
            display();
        }
    }

    public void display() {
        System.out.printf("HeatIndex: heat index is %f\n", heatindex);
    }
}
