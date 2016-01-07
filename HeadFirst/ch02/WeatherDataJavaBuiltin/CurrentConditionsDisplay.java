import java.util.Observable;
import java.util.Observer;

/**
 * Created by yangge on 1/4/2016.
 */
public class CurrentConditionsDisplay implements Observer {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            temperature = ((WeatherData) o).getTemperature();
            humidity = ((WeatherData) o).getHumidity();
            display();
        }
    }

    public void display() {
        System.out.printf("Current condition: temperature %f and humidity: %f\n", temperature, humidity);
    }
}
