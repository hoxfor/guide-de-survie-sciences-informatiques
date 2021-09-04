public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
    Cons newList = new Cons(f.apply(v), null);
    if (next != null) {
        newList.next = this.next.map(f);
    }
    return newList;
    }

    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        Cons newList = new Cons(0, null);
        Cons head = this;
        while (head != null) {
            if (p.filter(head.v)) {
                newList.v = head.v;
                if (head.next != null) {
                    newList.next = head.next.filter(p);
                }
                return newList;
            }
            head = head.next;
        }
        return null;
    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}