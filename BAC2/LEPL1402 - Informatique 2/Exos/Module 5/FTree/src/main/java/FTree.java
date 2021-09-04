import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {
        // Tree is balanced, so we can just check one branch (left or right)
        if (this.left() == null) {
            return 0;
        }
        int depth = 1;
        return depth + this.left().depth();
    }

    public abstract A value();

    public abstract FTree<A> left();

    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A, B> f) {
        if (this instanceof Node) {
            return new Node<>(f.apply(value()), this.left().map(f), this.right().map(f));
        } else if (this instanceof Leaf) {
            return new Leaf<>(f.apply(value()));
        }
        return null;
    }

}
