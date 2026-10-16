interface Greeter {
    default void hello() {
        System.out.println("Hello from Greeter");
    }
}

interface Welcomer {
    default void hello() {
        System.out.println("Hello from Welcomer");
    }
}

class Person implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();
        Welcomer.super.hello();
        System.out.println("Hello from Person");
    }
}

public class DiamondDemo {
    public static void main(String[] args) {
        new Person().hello();
    }
}
