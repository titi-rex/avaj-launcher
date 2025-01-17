package avaj_launcher;

public class AircraftFactory {

    private static AircraftFactory  INSTANCE;
    private static int              nAircraft;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AircraftFactory();
        return INSTANCE;
    }


    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        nAircraft++;

        switch (p_type) {
            default:
                System.out.println("WARNING: no aircraft type requested, default to JetPlane");
            case "JetPlane":
                return new JetPlane(nAircraft, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(nAircraft, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(nAircraft, p_name, p_coordinates);
        }
    }
}
