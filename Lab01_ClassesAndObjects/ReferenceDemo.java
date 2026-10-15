public class ReferenceDemo {
    public static void main(String[] args) {
        Student a = new Student();
        a.name = "Original";

        Student b = a;
        b.name = "Changed via b";
        System.out.println(a.name);

        Student c = new Student();
        c.name = "Changed via b";
        System.out.println(a == b);
        System.out.println(a == c);

        Student d = null;
        if (d == null) {
            System.out.println("d does not refer to any object");
        }
    }
}
