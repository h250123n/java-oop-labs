public class Car extends Vehicle {

    protected int doors;

    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
        System.out.println("Car constructor: " + doors + " doors");
    }
}
