import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int[] values = {14, 7, 23, 9, 31, 5, 18, 26, 12, 3};
        for (int v : values) {
            numbers.add(v);
        }

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + Collections.max(numbers));

        List<Integer> reversed = new ArrayList<>(numbers);
        Collections.reverse(reversed);
        System.out.println("Reversed: " + reversed);
    }
}
