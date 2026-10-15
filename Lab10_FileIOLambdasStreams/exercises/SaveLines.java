import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLines {
    public static void main(String[] args) {
        Path file = Path.of("typed-lines.txt");
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }

        try {
            Files.write(file, lines);
            System.out.println("Saved to " + file);

            System.out.println("Reading it back:");
            for (String line : Files.readAllLines(file)) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
