import java.util.Arrays;

public class StudentSortDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Tendai", 72), new Student("Anesu", 88),
            new Student("Mary", 65), new Student("Blessing", 88)
        };

        Arrays.sort(students);                         // Comparable: by name
        System.out.println("By name:  " + Arrays.toString(students));

        Arrays.sort(students, Student.BY_MARKS_DESC);  // Comparator: by marks, highest first
        System.out.println("By marks: " + Arrays.toString(students));
    }
}
