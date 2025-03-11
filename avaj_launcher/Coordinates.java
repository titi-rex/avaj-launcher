package avaj_launcher;

import avaj_launcher.exceptions.InvalidNumberException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public static int MAX_HEIGHT = 100;

    Coordinates(int p_longitude, int p_latitude, int p_height) throws InvalidNumberException {
        setLongitude(p_longitude);
        setLatitude(p_latitude);
        setHeight(p_height);
    }

    public String toString() {
        return "[" + longitude + "," + latitude + "," + height + "]";
    }

    public int getLongitude() { return longitude; }

    public int getLatitude() {return latitude; }

    public int getHeight() { return height; }

    public void setLongitude(int value) throws InvalidNumberException {
        if (value < 0)
            throw new InvalidNumberException("longitude must be positive");
        longitude = value;
    }

    public void setLatitude(int value) throws InvalidNumberException {
        if (value < 0)
            throw new InvalidNumberException("latitude must be positive");
        latitude = value; }

    public void setHeight(int value) throws InvalidNumberException {
        if (value < 0 || value > 100)
            throw new InvalidNumberException("height must be between 0-100");
        height = value;
    }

    public void increaseLongitude(int value) { longitude += value; }

    public void increaseLatitude(int value) { latitude += value; }

    public void increaseHeight(int value) {
        height += value;
        if (height > MAX_HEIGHT)
            height = MAX_HEIGHT;
    }

    public int sum() {
        return longitude + latitude + height;
    }
}
