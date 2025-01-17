package avaj_launcher.weather;

import java.util.LinkedList;
import java.util.List;

import avaj_launcher.flyable.Flyable;

public class Tower {

    private List<Flyable> observers = new LinkedList<Flyable>();

    public  void register(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            System.out.println("Tower say: " + p_flyable + " alreday registered!");
        } else {
            observers.add(p_flyable);
            System.out.println("Tower say: " + p_flyable + " registered to " + this.toString() + ".");
        }
    }

    public  void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower say: " + p_flyable + " unregistered from " + this.toString() + ".");
    }

    /**
     * go through suscribers List and trigger their notification method (updateConditions)
     */
    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
