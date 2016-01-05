/**
 * Created by yangge on 1/4/2016.
 */
public class HeatIndexDisplay implements Observer, DisplayElement {
    private double temperature;
    private double humidity;
    private double heatindex;
    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("HeatIndex: heat index is %f\n", heatindex);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.heatindex = 16.923 + 1.85212 / 10 * temperature + 5.39*humidity;
        display();
    }
}
