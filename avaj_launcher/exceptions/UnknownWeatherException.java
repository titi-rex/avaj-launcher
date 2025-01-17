package avaj_launcher.exceptions;

import avaj_launcher.flyable.Aircraft;

public class UnknownWeatherException extends Exception{

    public UnknownWeatherException () {
        super("Unknow weather");
    }

    public UnknownWeatherException (Aircraft aircraft) {
        super("Unknow weather for " + aircraft);
    }

}
