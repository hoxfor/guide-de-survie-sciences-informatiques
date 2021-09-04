import java.util.Stack;
import java.util.NoSuchElementException;

public class MyQueue<E> {

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    /**
     * Add an element to the end of the list
     *
     * @param elem The element to add
     */
    public void enqueue(E elem) {
        s1.push(elem);
    }

    /**
     * Remove the first element from the queue
     *
     * @return The oldest element in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) throw new NoSuchElementException();

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Peek at the first element of the queue
     *
     * @return The first element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() {
        if (s1.isEmpty() && s2.isEmpty()) throw new NoSuchElementException();

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        E elem = s2.pop();
        s2.push(elem);
        return elem;
    }

    /**
     * @return true if the queue is empty
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
