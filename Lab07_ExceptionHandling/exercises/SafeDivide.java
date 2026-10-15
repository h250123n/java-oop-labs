// Basic 1: read two integers with Scanner and divide, handling bad input and division by zero
import java.util.Scanner;

public class SafeDivide {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter the first integer: ");
            int a = Integer.parseInt(in.nextLine().trim());

            System.out.print("Enter the second integer: ");
            int b = Integer.parseInt(in.nextLine().trim());

            System.out.println(a + " / " + b + " = " + (a / b));    // ArithmeticException if b == 0
        } catch (NumberFormatException e) {
            System.out.println("Please enter whole numbers only.");
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero.");
        } finally {
            in.close();
            System.out.println("Done.");
        }
    }
}
