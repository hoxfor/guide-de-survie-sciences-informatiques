import java.util.ArrayList;
import java.util.List;

abstract class Observable {

    // An Observable object is the object that will broadcast information/state/messages to
    // other specific objects: its observers

    // String is the weather alert, Integer is the id of the zone to which the alert is relevant
    protected List<Pair<String, Integer>> zones = new ArrayList<>();

    protected List<Observer> subscribers = new ArrayList<>();

    /**
     * Returns an array containing all the observers of the station
     */
    abstract public Observer[] getSubscribers();

    /**
     * Sends a message to APPROPRIATE subscribers.
     */
    abstract public void broadcast(Pair<String, Integer> pair);

    /**
     * Adds an observer to the subscribers of the station
     */
    abstract public void addObserver(Observer sub);

    /**
     * Removes an observer from the subscribers of the station
     */
    abstract public boolean removeObserver(Observer sub);

    /**
     * Sets the current alert for a given zone. Note that
     * there must be AT MOST one alert for each zone and
     * when an alert is set, subscribers of the zone must
     * receive a message
     */
    abstract public void setAlert(String alert, int zone);


}
