package avaj_launcher.flyable;

import avaj_launcher.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    protected void sun() {
        say("Rise and shine. RISE AND SHINE!!!");
        coordinates.increaseLongitude(2);
        coordinates.increaseHeight(4);
    }

    protected void rain() {
        say("Il pleut, il mouille, je me noie!");
        coordinates.increaseHeight(5);
    }

    protected void fog() {
        say("J'y vois plus rien..");
        coordinates.increaseHeight(3);
    }

    protected void snow() {
        say("ATCHOUM!.. glglglgl...");
        coordinates.increaseHeight(-15);
    }

}
