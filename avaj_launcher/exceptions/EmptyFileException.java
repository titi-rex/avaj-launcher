package avaj_launcher.exceptions;

public class EmptyFileException extends ParsingException {


    public EmptyFileException() {
        super("empty file", 0);
    }
}
