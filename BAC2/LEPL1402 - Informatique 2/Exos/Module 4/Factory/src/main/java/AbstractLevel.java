abstract class AbstractLevel {

    protected LevelComponent[][] components;
    protected int size;

    /*
     * Return a string representation of this level
     */
    @Override
    abstract public String toString();

    abstract LevelComponent[][] getComponents();

    abstract int getSize();

}
