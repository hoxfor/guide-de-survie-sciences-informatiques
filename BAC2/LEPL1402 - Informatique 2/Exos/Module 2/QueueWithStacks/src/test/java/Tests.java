import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class Tests{

    @Test
    public void testEmptyNew() {
        MyQueue<Integer> q = new MyQueue<>();
        assertTrue("Your method empty() return false for newly created queue", q.empty());
    }

    @Test
    public void testNonEmpty() {
        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(10);
        assertFalse("Your method empty() return true on a non-emtpy list", q.empty());
    }

    @Test
    public void testEmpty() {
        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(10);
        q.dequeue();
        assertTrue("Your method empty() return false on an empty queue", q.empty());
    }

    @Test
    public void testQueue() {
        MyQueue<Integer> q = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals("Your queue and dequeue methods does not work correctly",
                    i, (int) q.dequeue());
        }
    }

    @Test(expected=NoSuchElementException.class)
    public void testEmptyDequeue() {
        MyQueue<Integer> q = new MyQueue<>();
        q.dequeue();
    }

    @Test
    public void testPeek() {
        MyQueue<Integer> q = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
            assertEquals("Your method peaks does not gives the first element in the list",
                    0, (int) q.peek());
        }
    }

    @Test(expected=NoSuchElementException.class)
    public void testEmptyPeek() {
        MyQueue<Integer> q = new MyQueue<>();
        q.peek();
    }

    @Test
    public void testPeekElement() {
        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(1);
        q.peek();
        assertFalse("Your method peek should not empty a list of 1 element", q.empty());
    }

}
