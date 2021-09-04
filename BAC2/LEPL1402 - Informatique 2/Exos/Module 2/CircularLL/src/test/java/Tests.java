import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Tests{

    @Test
    public void testSize(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertEquals(0, list.size());

        for(int i = 0; i < 10; i ++){
            list.enqueue(i);
            assertEquals(i+1, list.size());
        }

        for(int i = 9; i >= 0; i--){
            list.remove(i);
            assertEquals(i, list.size());
        }
    }

    @Test
    public void testEnqueue() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }

        ListNode<Integer> ptr = list.getFirst();
        for (int i = 0; i < 10; i ++) {
            assertEquals(i, (int) ptr.getItem());
            ptr = ptr.getNext();
        }
    }

    @Test
    public void testRemoveInOrder() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }

        ListNode<Integer> ptr = list.getFirst();
        for (int i = 0; i < 10; i ++) {
            ListNode<Integer> nextFirst = ptr.getNext();
            assertEquals(i, (int) list.remove(0));
            if (i != 9) {
                assertEquals(nextFirst, list.getFirst());
            } else {
                assertNull(list.getFirst());
            }
            ptr = nextFirst;
        }
    }

    @Test
    public void testRemoveMiddle() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }
        ListNode<Integer> first = list.getFirst();
        ListNode<Integer> last = list.getLast();

        list.remove(4);

        assertEquals(first, list.getFirst());
        assertEquals(last, list.getLast());

        ListNode<Integer> ptr = list.getFirst();
        for (int i = 0; i < 4; i++) {
            assertEquals(i, (int) ptr.getItem());
            ptr = ptr.getNext();
        }

        for (int i = 5; i < 10; i++) {
            assertEquals(i, (int) ptr.getItem());
            ptr = ptr.getNext();
        }
    }

    @Test
    public void testRemoveLast() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }

        ListNode<Integer> ptr = list.getFirst();
        for (int i = 0; i < 8; i++) {
            ptr = ptr.getNext();
        }

        list.remove(9);
        assertEquals(ptr, list.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBound() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }
        list.remove(15);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundNegative() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }
        list.remove(-12);
    }

    @Test
    public void firstAndLastUpdateEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < 10; i ++) {
            list.enqueue(i);
        }
        for (int i = 0; i < 10; i ++) {
            list.remove(0);
        }
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

}
