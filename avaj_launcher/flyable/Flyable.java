package avaj_launcher.flyable;

import avaj_launcher.weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions() ;

    public void registerTower(WeatherTower p_tower) {
        p_tower.register(this);
        weatherTower = p_tower;
    }
}
