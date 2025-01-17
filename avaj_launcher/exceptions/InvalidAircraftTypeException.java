package avaj_launcher.exceptions;

public class InvalidAircraftTypeException extends Exception {

    public InvalidAircraftTypeException(String got) {
        super("Invalid aircraft type: " + got);
    }

}
