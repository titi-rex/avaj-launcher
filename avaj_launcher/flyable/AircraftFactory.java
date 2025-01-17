package avaj_launcher.flyable;

import avaj_launcher.Coordinates;
import avaj_launcher.exceptions.InvalidAircraftTypeException;

public class AircraftFactory {

    private static AircraftFactory  INSTANCE;
    private static int              nAircraft;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AircraftFactory();
        return INSTANCE;
    }


    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraftTypeException {
        nAircraft++;

        switch (p_type) {
            default:
                throw new InvalidAircraftTypeException(p_type);
            case "JetPlane":
                return new JetPlane(nAircraft, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(nAircraft, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(nAircraft, p_name, p_coordinates);
        }
    }
}
