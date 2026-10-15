public class RectangleAliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 4;
        r1.height = 5;

        Rectangle r2 = r1;
        r2.width = 10;

        System.out.println("r1.width = " + r1.width);
    }
}
