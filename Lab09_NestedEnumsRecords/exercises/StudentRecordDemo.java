record Student(String name, int age) { }

public class StudentRecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Farai", 22);

        System.out.println(s1);
        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 equals s3: " + s1.equals(s3));
        System.out.println("Name component: " + s1.name());
        System.out.println("Age component: " + s1.age());
    }
}
