abstract class Visitable {

    protected Object [] elements;

    abstract void accept(Visitor visitor);

}
