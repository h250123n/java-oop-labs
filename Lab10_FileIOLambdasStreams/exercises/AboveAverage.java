import java.util.List;

record Student(String name, double marks) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro", 72),
            new Student("Farai", 58),
            new Student("Chipo", 85),
            new Student("Anesu", 91),
            new Student("Rudo", 64),
            new Student("Kuda", 49));

        double average = students.stream()
            .mapToDouble(Student::marks)
            .average()
            .orElse(0);
        System.out.printf("Class average: %.2f%n", average);

        System.out.println("Above average:");
        students.stream()
            .filter(s -> s.marks() > average)
            .map(Student::name)
            .sorted()
            .forEach(name -> System.out.println("  " + name));
    }
}
