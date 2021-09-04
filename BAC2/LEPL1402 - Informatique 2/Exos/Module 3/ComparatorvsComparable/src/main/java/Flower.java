import java.awt.Color;

public class Flower extends Plant implements Comparable<Plant>{

    private Color petalColor;

    public Flower(String name, int age, Color color) {
        super(name, age);
        this.petalColor = color;
    }

    public Color getPetalColor() {
        return petalColor;
    }

    /**
     * Should compare Flower by using name and age in that specific order
     * returns:
     *      > 0 if this is greater then o
     *      0 if they are equal
     *      < 0 if this is less than o
     */
    @Override
    public int compareTo(Plant o) {
        return super.compareTo(o);
    }
}
