package avaj_launcher.weather;

import avaj_launcher.Coordinates;

/**
 * signleton
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
     * @return
     */
    public String getCurrentWeather(Coordinates p_coordinates) {
        int i = (p_coordinates.sum() + 13) % 4;
        return weather[i];
    }


}
