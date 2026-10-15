// Intermediate 2: natural ordering with Comparable, extra ordering with a Comparator
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    public Student(String name, int marks) { this.name = name; this.marks = marks; }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    // natural ordering: by name (A to Z)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    // a second ordering, kept OUTSIDE the class's natural order: by marks, highest first
    public static final Comparator<Student> BY_MARKS_DESC =
            (a, b) -> Integer.compare(b.marks, a.marks);

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}
