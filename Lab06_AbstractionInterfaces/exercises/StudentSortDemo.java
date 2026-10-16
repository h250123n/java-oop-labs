import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }
    int getMarks()   { return marks; }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Tariro", 72),
            new Student("Farai", 88),
            new Student("Chipo", 65),
            new Student("Anesu", 91)));

        Collections.sort(students);
        System.out.println("By name: " + students);

        Comparator<Student> byMarks = Comparator.comparingInt(Student::getMarks);
        students.sort(byMarks);
        System.out.println("By marks (low to high): " + students);

        students.sort(byMarks.reversed());
        System.out.println("By marks (high to low): " + students);
    }
}
