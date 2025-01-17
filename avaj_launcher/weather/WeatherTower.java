package avaj_launcher.weather;

import avaj_launcher.Coordinates;

public class WeatherTower extends Tower {

    private WeatherProvider provider;

    public WeatherTower(WeatherProvider p_provider) {
        provider = p_provider;
    }

    public String getWeather(Coordinates p_coordinates) {
        return provider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }

    @Override
    public String toString() {
        return "weather tower";
    }
}
