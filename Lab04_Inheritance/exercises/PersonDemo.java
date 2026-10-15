public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Chipo", 40);
        Student s = new Student("Tariro", 20, "Software Engineering");
        Teacher t = new Teacher("Mr Moyo", 45, "Java");

        p.display();

        s.display();
        System.out.println("  Course: " + s.getCourse());

        t.display();
        System.out.println("  Subject: " + t.getSubject());
    }
}
