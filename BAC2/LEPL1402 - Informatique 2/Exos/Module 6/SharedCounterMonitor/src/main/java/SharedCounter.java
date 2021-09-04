public class SharedCounter {

    private int counter = 0;

    synchronized void inc() {
        counter++;
        notify();
    }

    synchronized void dec() {
        try {
            while (counter <= 0) wait();
        } catch (InterruptedException ignored) {
        }
        counter--;
        notify();
    }

    int get() {
        return this.counter;
    }

}