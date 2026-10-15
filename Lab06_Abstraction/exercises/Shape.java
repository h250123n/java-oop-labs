// Basic 1: abstract Shape with abstract area() and perimeter()
abstract class Shape {
    abstract double area();
    abstract double perimeter();

    // concrete method shared by every shape
    @Override
    public String toString() {
        return String.format("%s: area=%.2f, perimeter=%.2f",
                getClass().getSimpleName(), area(), perimeter());
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
    Rectangle(double width, double height) { this.width = width; this.height = height; }
    @Override double area()      { return width * height; }
    @Override double perimeter() { return 2 * (width + height); }
}

// A square is a rectangle with equal sides, so it reuses Rectangle's code
class Square extends Rectangle {
    Square(double side) { super(side, side); }
}
