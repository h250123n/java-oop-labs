public class MultiBlockDemo {

    static {
        System.out.println("static block 1");
    }

    {
        System.out.println("instance block 1");
    }

    static {
        System.out.println("static block 2");
    }

    {
        System.out.println("instance block 2");
    }

    MultiBlockDemo() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("main starts");
        new MultiBlockDemo();
        System.out.println("---");
        new MultiBlockDemo();
    }
}
