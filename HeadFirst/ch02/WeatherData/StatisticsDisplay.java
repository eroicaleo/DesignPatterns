/**
 * Created by yangge on 12/30/2015.
 */
public class StatisticsDisplay implements Display {
    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.printf("Statistics Display: Temperature is %f, Humidity is %f, Pressure is %f\n", temp,
                humidity, pressure);
    }
}
