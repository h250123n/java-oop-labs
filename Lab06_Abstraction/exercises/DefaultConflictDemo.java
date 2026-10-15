// Challenge: two interfaces with the same default method
interface Greeter {
    default void hello() { System.out.println("Hello from Greeter"); }
}

interface Welcomer {
    default void hello() { System.out.println("Hello from Welcomer"); }
}

// Without the override below this class would NOT compile: the compiler cannot choose.
class Receptionist implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();     // explicitly pick one interface's version
        Welcomer.super.hello();    // or call both
        System.out.println("Hello from Receptionist");
    }
}

public class DefaultConflictDemo {
    public static void main(String[] args) {
        new Receptionist().hello();
    }
}
