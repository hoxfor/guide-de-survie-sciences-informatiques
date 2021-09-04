import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int section;
    private Map<String, Double> courses_results = new HashMap<>();

    public Student(String firstName, String lastName, int section, Map<String, Double> courses_results) {
        this.courses_results = courses_results;
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSection() {
        return section;
    }

    public Map<String, Double> getCourses_results() {
        return courses_results;
    }

    @Override
    public int compareTo(Student student) {
        // Advanced sorting
        Comparator<Student> my_comparator = Comparator
                .comparing(Student::getSection)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getLastName)
                .thenComparing(
                        (s) -> s.getCourses_results().values().stream().reduce(0.0, Double::sum),
                        Comparator.reverseOrder()
                );
        return my_comparator.compare(this, student);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Student)) {
            return false;
        }

        return this.compareTo((Student) obj) == 0;
    }
}