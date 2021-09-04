public class Node<A> extends FTree<A> {

    private final A value;
    private final FTree<A> left, right;

    public Node(final A a, FTree<A> left, FTree<A> right) {
        this.value = a;
        this.left = left;
        this.right = right;
    }

    @Override
    public A value() {
        return this.value;
    }

    @Override
    public FTree<A> left() {
        return this.left;
    }

    @Override
    public FTree<A> right() {
        return this.right;
    }
}
