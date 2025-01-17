package avaj_launcher.flyable;

import avaj_launcher.Coordinates;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }


    protected void sun() {
        say("Rise and shine. RISE AND SHINE!!!");
        coordinates.increaseLongitude(10);
        coordinates.increaseHeight(2);
    }

    protected void rain() {
        say("Il pleut, il mouille, je me noie!");
        coordinates.increaseLongitude(5);
    }

    protected void fog() {
        say("J'y vois plus rien..");
        coordinates.increaseLongitude(1);
    }

    protected void snow() {
        say("ATCHOUM!.. glglglgl...");
        coordinates.increaseHeight(-12);
    }

}
