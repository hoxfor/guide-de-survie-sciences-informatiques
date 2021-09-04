import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class Tests {


    @Test
    public void basicTest(){

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume",20));
        persons.add(new Person("John",50));
        persons.add(new Person("Guillaume",10));
        persons.add(new Person("John",10));
        persons.add(new Person("Luc",5));

        ArrayList<Person> sorted = new ArrayList<>();
        sorted.add(new Person("Guillaume",10));
        sorted.add(new Person("Guillaume",20));
        sorted.add(new Person("John",10));
        sorted.add(new Person("John",50));
        sorted.add(new Person("Luc",5));


        Person.sortPerson(persons);

        for (int i = 0; i < sorted.size(); i++) {
            assertEquals(sorted.get(i).toString(), persons.get(i).toString());
        }
    }

}

