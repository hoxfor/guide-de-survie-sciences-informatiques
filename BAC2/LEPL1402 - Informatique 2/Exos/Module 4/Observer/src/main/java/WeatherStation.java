public class WeatherStation extends Observable {
    @Override
    public Observer[] getSubscribers() {
        Observer[] observers = new Observer[subscribers.size()];
        for (int i = 0; i < observers.length; i++) {
            observers[i] = subscribers.get(i);
        }
        return observers;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for (Observer subscriber : subscribers) {
            if (subscriber.getZone() == pair.getZone()) {
                subscriber.update(pair);
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        if (subscribers.contains(sub)) {
            subscribers.remove(sub);
            return true;
        }
        return false;
    }

    @Override
    public void setAlert(String alert, int zone) {
        for (Observer subscriber: subscribers) {
            if (subscriber.getZone() == zone) {
                subscriber.update(alert);
            }
        }
    }
}
