public class Employee {

    private static int nextId = 1;

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    public Employee(String name) {
        this(name, "Unassigned");
    }

    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public void display() {
        System.out.printf("ID %d: %s, %s, salary %.2f%n", employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", "IT", 3500.00);
        Employee e2 = new Employee("Nyasha", "HR");
        Employee e3 = new Employee("Farai");
        Employee e4 = new Employee(e1);

        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
