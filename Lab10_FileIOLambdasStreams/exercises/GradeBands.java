import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {

    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2]));
    }

    String band() {
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        return "C";
    }
}

public class GradeBands {
    public static void main(String[] args) {
        Path input = Path.of("learners.csv");

        List<Learner> learners = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(input)) {
                if (!line.isBlank()) {
                    learners.add(Learner.fromCsv(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read " + input + ": " + e.getMessage());
            return;
        }

        Map<String, List<Learner>> byBand = learners.stream()
            .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

        for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
            String band = entry.getKey();
            List<String> lines = new ArrayList<>();
            lines.add("Band " + band + " report (" + entry.getValue().size() + " learners)");
            for (Learner l : entry.getValue()) {
                lines.add(String.format("%-8s roll=%d gpa=%.1f", l.name(), l.roll(), l.gpa()));
            }

            Path report = Path.of("report-" + band + ".txt");
            try {
                Files.write(report, lines);
                System.out.println("Wrote " + report + " (" + entry.getValue().size() + " learners)");
            } catch (IOException e) {
                System.out.println("Could not write " + report + ": " + e.getMessage());
            }
        }
    }
}
