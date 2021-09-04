public class Launcher {

    /**
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t) {
        Counter[] counters = new Counter[t.length];
        for (int i = 0; i < t.length; i++) {
            counters[i] = new Counter();
            t[i] = new Thread(counters[i], String.valueOf(i));
            t[i].start();
        }
        for (Thread thread : t) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }
        return counters;
    }
}
