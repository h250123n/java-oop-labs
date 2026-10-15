// Program 6.1 (part 1): abstract class and two concrete subclasses.
// NOTE: the manual shows VehicleDemo in this same file, but a public class must live in
// a file with its own name, so VehicleDemo is in VehicleDemo.java.
abstract class Vehicle {
    private final String plate;

    Vehicle(String plate) { this.plate = plate; }   // EXPLAIN: abstract classes CAN have constructors

    // EXPLAIN: abstract -> no body; every concrete subclass MUST provide one
    abstract double fuelCostPerKm();

    // concrete method shared by all vehicles (template of common behaviour)
    double tripCost(double km) {
        return km * fuelCostPerKm();
    }

    String getPlate() { return plate; }
}

class Truck extends Vehicle {
    Truck(String plate) { super(plate); }
    @Override double fuelCostPerKm() { return 0.80; }
}

class Motorbike extends Vehicle {
    Motorbike(String plate) { super(plate); }
    @Override double fuelCostPerKm() { return 0.15; }
}
