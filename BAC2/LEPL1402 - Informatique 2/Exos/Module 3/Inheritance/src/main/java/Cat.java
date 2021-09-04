public class Cat extends Animal {

    // useful for the actForTestMethod function
    private final String forTestMethod = "Thinking";

    public Cat() {
        super("Cat");
    }

    public void actForTestMethod() {
        super.act(forTestMethod);
    }

}
