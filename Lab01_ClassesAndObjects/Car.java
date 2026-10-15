import java.time.Year;

public class Car {

    String brand;
    int year;
    int mileage;

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }

    boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 2018;
        car1.mileage = 85000;

        Car car2 = new Car();
        car2.brand = "Mazda";
        car2.year = 1995;
        car2.mileage = 240000;

        Car car3 = new Car();
        car3.brand = "Ford";
        car3.year = 2005;
        car3.mileage = 160000;

        Car[] cars = {car1, car2, car3};
        for (Car car : cars) {
            car.display();
            System.out.println("  Antique? " + car.isAntique());
        }
    }
}
