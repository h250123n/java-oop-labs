public class Circle {

    private static int count = 0;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);
    }

    public static int getCount() {
        return count;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.printf("Circle radius = %.1f, area = %.2f%n", radius, area());
    }

    public static void main(String[] args) {
        System.out.println("Circles so far: " + Circle.getCount());

        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();
        Circle c3 = new Circle(2.5);

        c1.display();
        c2.display();
        c3.display();
        System.out.println("Circles created: " + Circle.getCount());
    }
}
