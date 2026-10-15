public class Intern extends Employee {

    private static final double STIPEND = 600.0;

    public Intern(String name) {
        super(name, 0);
    }

    @Override
    public double calculatePay() {
        return STIPEND;
    }
}
