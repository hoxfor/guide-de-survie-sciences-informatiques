public class Animal {

    private String name;
    private StringBuilder event_recorder;

    public Animal(String name) {
        this.name = name;
        this.event_recorder = new StringBuilder();
    }

    private Animal() {
        this.name = "Unknown animal";
        this.event_recorder = new StringBuilder();
    }

    public void clearStringBuilder() {
        event_recorder.setLength(0);
    }

    public void addStringToLogger(String toBeAdded) {
        event_recorder.append(toBeAdded+"\n");
    }

    public String logs() {
        return event_recorder.toString();
    }

    /**
     *   You must create the following string to be added to event_recorder :
     *   "AnimalName is performing the following action: Action"
     *       Example : "Cat is performing the following action: Sleep"
     *   Hint : Use the addStringToLogger method
     */
    public void act(String action) {
        addStringToLogger(String.format("%s is performing the following action: %s", this.getName(), action));

    }

    public String getName() {
        return this.name;
    }

}
