// Program 6.1 (part 2): run this one with  java VehicleDemo
public class VehicleDemo {
    public static void main(String[] args) {
        // Vehicle v = new Vehicle("X");   // COMPILE ERROR: Vehicle is abstract
        Vehicle[] fleet = { new Truck("TRK-1"), new Motorbike("MB-7") };

        for (Vehicle v : fleet) {
            System.out.printf("%s: 100 km costs %.2f%n", v.getPlate(), v.tripCost(100));
        }
    }
}
