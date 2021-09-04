import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    public static void sortPerson(ArrayList<Person> persons) {
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.name.equals(o2.name)) return Integer.compare(o1.age, o2.age);
                return Integer.compare(o1.name.compareTo(o2.name), 0);
            }
        });
    }
}

