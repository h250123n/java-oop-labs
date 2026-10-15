public class Temperature {

    private final double celsius;

    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5 / 9);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.1f C = %.1f F", getCelsius(), getFahrenheit());
    }

    public static void main(String[] args) {
        Temperature boiling = Temperature.fromCelsius(100);
        Temperature body = Temperature.fromFahrenheit(98.6);

        System.out.println(boiling);
        System.out.println(body);
    }
}
