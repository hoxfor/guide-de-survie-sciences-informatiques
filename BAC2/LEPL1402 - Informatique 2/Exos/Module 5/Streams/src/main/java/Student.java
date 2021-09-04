import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int section;
    private Map<String, Double> coursesResults = new HashMap<>();

    public Student(String firstName, String lastName, int section, Map<String, Double> coursesResults) {
        this.coursesResults = coursesResults;
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

    public Map<String, Double> getCoursesResults() {
        return coursesResults;
    }

    @Override
    public int compareTo(Student student) {
        // Advanced sorting
        Comparator<Student> myComparator = Comparator
                .comparing(Student::getSection)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getLastName)
                .thenComparing(
                        (s) -> s.getCoursesResults().values().stream().reduce(0.0, Double::sum),
                        Comparator.reverseOrder()
                );
        return myComparator.compare(this, student);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Student)) {
            return false;
        }

        return this.compareTo((Student) obj) == 0;
    }
}
