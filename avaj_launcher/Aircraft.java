package avaj_launcher;

public class Aircraft extends Flyable {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name= p_name;
        coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                this.sun();
                break;
            case "RAIN":
                this.rain();
                break;
            case "FOG":
                this.fog();
                break;
            case "SNOW":
                this.snow();
                break;
            default:
                System.out.println("ERROR: no weather for " + this.toString());
                break;
        }

        if (coordinates.getHeight() > 100) {
            coordinates.setHeight(100);
        } else if (coordinates.getHeight() <= 0) {
            System.out.println(this.toString() + " landing.");
            weatherTower.unregister(this);
        }
    }

    protected void sun() {say("sun"); }

    protected void rain() { say("rain"); }

    protected void fog() { say("fog"); }

    protected void snow() { say("snow"); }

    protected void say(String sentence) {
        System.out.println(this.toString() + ": " + sentence);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }

}
