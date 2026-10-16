abstract class Shape {
    abstract double area();
    abstract double perimeter();

    void print(String name) {
        System.out.printf("%-10s area = %.2f, perimeter = %.2f%n", name, area(), perimeter());
    }
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override double area()      { return Math.PI * radius * radius; }
    @Override double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private final double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override double area()      { return width * height; }
    @Override double perimeter() { return 2 * (width + height); }
}

class Square extends Shape {
    private final double side;

    Square(double side) { this.side = side; }

    @Override double area()      { return side * side; }
    @Override double perimeter() { return 4 * side; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(5), new Rectangle(4, 6), new Square(3) };
        String[] names = { "Circle", "Rectangle", "Square" };

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].print(names[i]);
        }
    }
}
