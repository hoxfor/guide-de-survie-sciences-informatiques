public class Div extends Node implements Visitable {
    public Div(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int accept(Visitor visitor) {
        if (getRight().accept(visitor) == 0) throw new IllegalArgumentException("Cannot divide by 0");
        return getLeft().accept(visitor) / getRight().accept(visitor);
    }
}
