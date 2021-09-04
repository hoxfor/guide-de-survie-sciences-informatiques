import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {
    private StudentStreamFunction streamFunction = new StudentFunctions();

    @Test
    @Grade
    @GradeFeedback(message = "findFirst() didn't work for a stream of just one student", onFail = true, onTimeout = true)
    public void findOne_simple() {
        Map<String, Double> grades = new HashMap<>();
        Map<String, Predicate<?>> conditions = new HashMap<>();

        Student student = new Student("Jacques", "42", 42, grades);
        Student student1 = new Student("Jacques", "42", 12, grades);

        Predicate<String> p1 = (s) -> s.equalsIgnoreCase("jacques");
        Predicate<Integer> p2 = (i) -> i == 42;
        conditions.put("firstName", p1);
        conditions.put("section", p2);

        assertEquals(student, streamFunction.findFirst(Stream.of(student), conditions));
        assertNull(streamFunction.findFirst(Stream.of(student1), conditions));
    }

    // Add more tests here.
}
