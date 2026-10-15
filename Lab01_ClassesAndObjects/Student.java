public class Student {

    String name;
    int rollNo;
    double gpa;

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo + ", GPA: " + gpa);
    }

    boolean isHonours() {
        return gpa >= 3.5;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Tariro";
        s1.rollNo = 101;
        s1.gpa = 3.8;

        Student s2 = new Student();
        s2.name = "Farai";
        s2.rollNo = 102;
        s2.gpa = 3.1;

        s1.display();
        s2.display();
        System.out.println(s1.name + " honours? " + s1.isHonours());
        System.out.println(s2.name + " honours? " + s2.isHonours());
    }
}
