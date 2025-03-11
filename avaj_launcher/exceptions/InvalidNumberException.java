package avaj_launcher.exceptions;

public class InvalidNumberException extends Exception {

    public InvalidNumberException() {
        super("invalid number");
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
