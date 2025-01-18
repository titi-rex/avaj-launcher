package avaj_launcher.weather;

import java.util.LinkedList;
import java.util.List;

import avaj_launcher.flyable.Flyable;

public class Tower {

    private List<Flyable>   observers = new LinkedList<Flyable>();
    private List<CachedJob> cached = new LinkedList<CachedJob>();
    private boolean         busy = false;

    public  void register(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            System.out.println("Tower say: " + p_flyable + " alreday registered!");
        } else {
            observers.add(p_flyable);
            System.out.println("Tower say: " + p_flyable + " registered to " + this.toString() + ".");
        }
    }

    public  void unregister(Flyable p_flyable) {
        if (busy == false)
            this._unregister(p_flyable);
        else
            cached.add(new CachedJob(this::_unregister, p_flyable));
        System.out.println("Tower say: " + p_flyable + " unregistered from " + this.toString() + ".");
    }

    private void _unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
    }

    /**
     * go through suscribers List and trigger their notification method (updateConditions)
     */
    protected void conditionChanged() {
        busy = true;
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
        busy = false;
        for (CachedJob cachedJob : cached) {
            cachedJob.execute();
        }
        cached.clear();
    }


    private class CachedJob {
        
        private Job     todo;
        private Flyable target;

        CachedJob(Job job, Flyable flyable) {
            todo = job;
            target = flyable;
        }

        private void execute() {
            todo.job(target);
        }
 
        @FunctionalInterface
        private interface Job {
            void job(Flyable flyable);
        }
    }
}
