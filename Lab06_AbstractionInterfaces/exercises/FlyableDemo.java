interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("The bird flaps its wings and flies");
    }
}

class Aeroplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("The aeroplane takes off from the runway");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };

        for (Flyable f : things) {
            f.fly();
        }
    }
}
