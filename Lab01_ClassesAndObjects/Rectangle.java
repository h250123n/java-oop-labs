public class Rectangle {

    double width;
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[5];
        double[][] sizes = {{2, 3}, {5, 4}, {1.5, 8}, {6, 6}, {3, 2.5}};

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].width = sizes[i][0];
            rectangles[i].height = sizes[i][1];
            System.out.printf("Rectangle %d: %.1f x %.1f, area = %.2f, perimeter = %.2f%n",
                    i + 1, rectangles[i].width, rectangles[i].height,
                    rectangles[i].area(), rectangles[i].perimeter());
        }

        Rectangle largest = rectangles[0];
        for (Rectangle r : rectangles) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.printf("Largest: %.1f x %.1f, area = %.2f%n",
                largest.width, largest.height, largest.area());
    }
}
