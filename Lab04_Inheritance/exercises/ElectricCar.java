public class ElectricCar extends Car {

    private int batteryKwh;

    public ElectricCar(String brand, int doors, int batteryKwh) {
        super(brand, doors);
        this.batteryKwh = batteryKwh;
        System.out.println("ElectricCar constructor: " + batteryKwh + " kWh");
    }

    public void describe() {
        System.out.println(brand + ", " + doors + " doors, " + batteryKwh + " kWh battery");
    }
}
