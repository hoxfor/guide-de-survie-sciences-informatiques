import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        Cons<R> newList = new Cons<>(function.apply(v), null);
        if (next != null) {
            newList.next = next.map(function);
        }
        return newList;
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        Cons <E> newList = new Cons<>(v, null);
        Cons <E> head = this;
        while (head != null) {
            if (predicate.test(head.v)) {
                newList.v = head.v;
                if (head.next != null) {
                    newList.next = head.next.filter(predicate);
                }
                return newList;
            }
            head = head.next;
        }
        return null;
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }
}
