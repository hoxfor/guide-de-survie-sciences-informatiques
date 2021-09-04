public class Tree extends Plant implements Comparable<Plant> {

    private int height;

    public Tree(String name, int age, int height) {
        super(name, age);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Should compare Tree by using name and age in that specific order
     * returns:
     * > 0 if this is greater then o
     * 0 if they are equal
     * < 0 if this is less than o
     */
    @Override
    public int compareTo(Plant o) {
        return super.compareTo(o);
    }
}
