public class Temperature {

    private static final double ABSOLUTE_ZERO_KELVIN = 0.0;

    private double kelvin;

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return getCelsius() * 9 / 5 + 32;
    }

    public void setCelsius(double celsius) {
        double newKelvin = celsius + 273.15;
        if (newKelvin < ABSOLUTE_ZERO_KELVIN) {
            throw new IllegalArgumentException("Below absolute zero (-273.15 C)");
        }
        this.kelvin = newKelvin;
    }

    @Override
    public String toString() {
        return String.format("%.2f C = %.2f F", getCelsius(), getFahrenheit());
    }

    public static void main(String[] args) {
        Temperature t = new Temperature(25);
        System.out.println(t);

        t.setCelsius(-40);
        System.out.println(t);

        t.setCelsius(100);
        System.out.println(t);

        try {
            t.setCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        System.out.println("Still: " + t);
    }
}
