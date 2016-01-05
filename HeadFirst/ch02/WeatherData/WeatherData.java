/**
 * Created by yangge on 12/30/2015.
 */
public class WeatherData {

    private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
    private StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
    private ForecastDisplay forecastDisplay = new ForecastDisplay();

    public double getTemperature() {
        return 20.0;
    }

    public double getHumidity() {
        return 23.0;
    }

    public double getPressure() {
        return 28.0;
    }

    public void measurementsChanged() {
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();

        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }

    public static void main(String[] args) {
        System.out.println("Hello WeatherData!");

        WeatherData wd = new WeatherData();
        wd.measurementsChanged();
    }
}
