import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TextStats {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("File name (press Enter for sample.txt): ");
        String name = in.nextLine().trim();
        if (name.isEmpty()) {
            name = "sample.txt";
        }

        try {
            List<String> lines = Files.readAllLines(Path.of(name));

            int words = 0;
            int characters = 0;
            for (String line : lines) {
                characters += line.length();
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length;
                }
            }

            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters (excluding line breaks): " + characters);
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
