package avaj_launcher.exceptions;

public class ParsingException extends Exception {

    public int lineNumber;

    public ParsingException(String msg, int p_lineNumber) {
        super("parsing: " + msg);
        lineNumber = p_lineNumber;
    }

}
