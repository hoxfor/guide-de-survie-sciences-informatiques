public class Leaf implements Visitable {

    private int value;

    public Leaf(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int accept(Visitor visitor) {
        return value;
    }
}
