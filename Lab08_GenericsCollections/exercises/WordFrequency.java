import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a paragraph: ");
        String text = in.hasNextLine() ? in.nextLine() : "";

        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.toLowerCase().split("\\W+")) {
            if (!word.isEmpty()) {
                freq.merge(word, 1, Integer::sum);
            }
        }

        if (freq.isEmpty()) {
            System.out.println("No words entered.");
            return;
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
