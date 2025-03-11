package avaj_launcher.weather;

import java.util.Random;

import avaj_launcher.Coordinates;

/**
 * singleton
 */
public class WeatherProvider {

    private static WeatherProvider  INSTANCE;
    private static String[]         weather = {"RAIN","FOG","SUN","SNOW"};
    
    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (INSTANCE == null)
            INSTANCE = new WeatherProvider();
        return INSTANCE;
    }

    /**
     * generate weather based on coordinate
     * @param p_coordinates
     * @return weather generated
     */
    public String getCurrentWeather(Coordinates p_coordinates) {
        int i = (new Random().nextInt(weather.length) + p_coordinates.sum()) % 4;
        return weather[i];
    }

}
