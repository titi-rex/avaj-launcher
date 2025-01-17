package avaj_launcher;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    protected void sun() {
        say("Rise and shine. RISE AND SHINE!!!");
        coordinates.increaseLatitude(10);
        coordinates.increaseHeight(2);
    }

    protected void rain() {
        say("Il pleut, il mouille, je me noie!");
        coordinates.increaseLatitude(5);
    }

    protected void fog() {
        say("J'y vois plus rien..");
        coordinates.increaseLatitude(1);
    }

    protected void snow() {
        say("ATCHOUM!.. glglglgl...");
        coordinates.increaseHeight(-7);
    }
}

