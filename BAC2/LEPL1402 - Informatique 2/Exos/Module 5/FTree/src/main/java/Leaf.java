
public class Leaf<A> extends FTree<A> {

    private final A value;

    public Leaf(A a) {
        this.value = a;
    }

    @Override
    public A value() {
        return this.value;
    }

    @Override
    public FTree<A> left() {
        return null;
    }

    @Override
    public FTree<A> right() {
        return null;
    }
}
