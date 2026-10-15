// Basic 2: access an array element and catch ArrayIndexOutOfBoundsException
public class ArrayAccess {

    static int elementAt(int[] data, int index) {
        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is invalid: " + e.getMessage());
            return -1;                       // simple fallback value
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 10, 15};
        System.out.println("data[1] = " + elementAt(data, 1));
        System.out.println("data[7] = " + elementAt(data, 7));
        System.out.println("data[-1] = " + elementAt(data, -1));
    }
}
