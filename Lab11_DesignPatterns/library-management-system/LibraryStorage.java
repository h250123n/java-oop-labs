import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryStorage {

    private final Path itemsFile;
    private final Path membersFile;
    private final Path loansFile;
    private final Path directory;

    public LibraryStorage(String directoryName) {
        this.directory = Path.of(directoryName);
        this.itemsFile = directory.resolve("items.csv");
        this.membersFile = directory.resolve("members.csv");
        this.loansFile = directory.resolve("loans.csv");
    }

    public void save(Library library) throws IOException {
        Files.createDirectories(directory);

        List<String> itemLines = new ArrayList<>();
        for (LibraryItem item : library.getItems()) {
            itemLines.add(item.type() + "," + item.getId() + "," + item.getTitle() + "," + item.extraField());
        }
        Files.write(itemsFile, itemLines);

        List<String> memberLines = new ArrayList<>();
        for (Member member : library.getMembers()) {
            memberLines.add(member.getId() + "," + member.getName());
        }
        Files.write(membersFile, memberLines);

        List<String> loanLines = new ArrayList<>();
        for (Loan loan : library.getLoans()) {
            loanLines.add(loan.getItem().getId() + "," + loan.getMember().getId() + ","
                    + loan.getBorrowDate() + ","
                    + (loan.getReturnDate() == null ? "" : loan.getReturnDate()));
        }
        Files.write(loansFile, loanLines);
    }

    public void load(Library library) throws IOException {
        for (String line : readLines(itemsFile)) {
            String[] p = line.split(",", -1);
            try {
                switch (p[0]) {
                    case "BOOK" -> library.addItem(new Book(p[1], p[2], p[3]));
                    case "DVD"  -> library.addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
                    default -> throw new IllegalArgumentException("Unknown item type " + p[0]);
                }
            } catch (RuntimeException e) {
                throw new IOException("Bad line in " + itemsFile + ": " + line + " (" + e.getMessage() + ")");
            }
        }

        for (String line : readLines(membersFile)) {
            String[] p = line.split(",", -1);
            try {
                library.registerMember(new Member(p[0], p[1]));
            } catch (RuntimeException e) {
                throw new IOException("Bad line in " + membersFile + ": " + line + " (" + e.getMessage() + ")");
            }
        }

        for (String line : readLines(loansFile)) {
            String[] p = line.split(",", -1);
            try {
                LocalDate returned = p[3].isEmpty() ? null : LocalDate.parse(p[3]);
                library.restoreLoan(p[0], p[1], LocalDate.parse(p[2]), returned);
            } catch (RuntimeException e) {
                throw new IOException("Bad line in " + loansFile + ": " + line + " (" + e.getMessage() + ")");
            }
        }
    }

    private List<String> readLines(Path file) throws IOException {
        if (!Files.exists(file)) {
            return List.of();
        }
        return Files.readAllLines(file).stream()
            .filter(line -> !line.isBlank())
            .toList();
    }
}
