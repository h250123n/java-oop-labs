import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
            "Tariro", "Farai", "Tariro", "Rudo", "Farai", "Chipo", "Rudo"));
        System.out.println("Original: " + names);

        Set<String> unique = new LinkedHashSet<>(names);
        List<String> cleaned = new ArrayList<>(unique);
        System.out.println("Without duplicates: " + cleaned);
    }
}
