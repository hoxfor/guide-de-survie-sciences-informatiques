import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.Comparator;

public interface StudentStreamFunction {

    // In order to test your code efficiently, input conditions take the
    // form of a Map<String, Predicate<?>> object structured as follows:
    //    Key   : String corresponding to one of the fields of Student objects
    //            ("firstName", "lastName", "section", "courses_results")
    //    Value : Predicate bound to the type of the field on which the condition applies
    //
    // For example:
    //    Key   : "firstName"
    //    Value : Predicate<String>


    // Returns a student that matches the given conditions
    // If there is none, returns null
    public Student findFirst(Stream<Student> studentsStream,
                             Map<String, Predicate<?>> conditions);

    // Returns an array of student(s) that match the given conditions
    public Student[] findAll(Stream<Student> studentsStream,
                             Map<String, Predicate<?>> conditions);

    // Returns true if there are at least n student(s) that match the given conditions
    public boolean exists(Stream<Student> studentsStream,
                          Map<String, Predicate<?>> conditions,
                          int n);

    // Returns an array of student(s) that match the given conditions,
    // ordered according to the given comparator
    public Student[] filterThenSort(Stream<Student> studentsStream,
                                    Map<String, Predicate<?>> conditions,
                                    Comparator<Student> comparator);

}