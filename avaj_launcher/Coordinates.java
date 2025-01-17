package avaj_launcher;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public String toString() {
        return "[" + longitude + "," + latitude + "," + height + "]";
    }

    public int getLongitude() { return longitude; }

    public int getLatitude() {return latitude; }

    public int getHeight() { return height; }

    public void setLongitude(int value) { longitude = value; }

    public void setLatitude(int value) { latitude = value; }

    public void setHeight(int value) { height = value; }

    public void increaseLongitude(int value) { longitude += value; }

    public void increaseLatitude(int value) { latitude += value; }

    public void increaseHeight(int value) { height += value; }

    public void increase(int p_longitude, int p_latitude, int p_height) {
        longitude += p_longitude;
        latitude += p_latitude;
        height += p_height;
    }

    public void increase(int[] values) {
        if (values.length != 3)
            return ;
        longitude += values[0];
        latitude += values[1];
        height += values[2];
    }

    public int sum() {
        return longitude + latitude + height;
    }
}
