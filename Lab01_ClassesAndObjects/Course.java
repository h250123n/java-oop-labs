public class Course {
    String title;
    Student topStudent;

    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Rudo";
        s.gpa = 3.9;

        Course c = new Course();
        c.title = "Object-Oriented Programming";
        c.topStudent = s;

        System.out.println(c.title + " top student: " + c.topStudent.name);
    }
}
