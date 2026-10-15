// Basic 2: an interface for a capability shared by unrelated classes
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override public void fly() { System.out.println("Bird flaps its wings and flies"); }
}

class Aeroplane implements Flyable {
    @Override public void fly() { System.out.println("Aeroplane takes off using jet engines"); }
}
