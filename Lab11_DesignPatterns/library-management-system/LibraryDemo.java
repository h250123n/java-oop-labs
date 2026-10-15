import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class LibraryDemo {

    public static void main(String[] args) throws Exception {
        Library library = new Library();

        library.addItem(new Book("B001", "Clean Code", "Robert Martin"));
        library.addItem(new Book("B002", "Effective Java", "Joshua Bloch"));
        library.addItem(new Book("B003", "Head First Java", "Kathy Sierra"));
        library.addItem(new Dvd("D001", "The Matrix", 136));
        library.addItem(new Dvd("D002", "Inception", 148));

        library.registerMember(new Member("M001", "Tariro"));
        library.registerMember(new Member("M002", "Farai"));

        System.out.println("=== Polymorphism: one call, different loan periods ===");
        for (LibraryItem item : library.getItems()) {
            System.out.println(item.getTitle() + " -> " + item.loanPeriodDays() + " days");
        }

        System.out.println();
        System.out.println("=== Borrowing ===");
        LocalDate day = LocalDate.of(2026, 10, 1);
        System.out.println(library.borrow("M001", "B001", day));
        System.out.println(library.borrow("M001", "D001", day));
        System.out.println(library.borrow("M001", "B002", day));

        System.out.println();
        System.out.println("=== Edge case: member limit (3 loans) ===");
        try {
            library.borrow("M001", "B003", day);
        } catch (MemberLimitExceededException e) {
            System.out.println("Refused: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Edge case: item already on loan ===");
        try {
            library.borrow("M002", "B001", day);
        } catch (ItemNotAvailableException e) {
            System.out.println("Refused: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Edge case: unknown id ===");
        try {
            library.borrow("M999", "B001", day);
        } catch (IllegalArgumentException e) {
            System.out.println("Refused: " + e.getMessage());
        }

        LocalDate today = LocalDate.of(2026, 10, 20);
        System.out.println();
        System.out.println("=== Overdue items on " + today + " ===");
        for (Loan loan : library.findOverdue(today)) {
            System.out.println(loan + " (" + loan.daysOverdue(today) + " days overdue)");
        }

        System.out.println();
        System.out.println("=== Returning a DVD, then searching by title ===");
        System.out.println(library.giveBack("D001", today));
        for (LibraryItem item : library.searchByTitle("java")) {
            System.out.println(item);
        }

        System.out.println();
        System.out.println("=== Persistence: save, then reload into a new Library ===");
        LibraryStorage storage = new LibraryStorage("demo-data");
        try {
            storage.save(library);
            Library reloaded = new Library();
            storage.load(reloaded);
            System.out.println("Reloaded " + reloaded.getItems().size() + " items, "
                    + reloaded.getMembers().size() + " members, "
                    + reloaded.getLoans().size() + " loans");
            System.out.println("B001 available after reload? " + reloaded.findItem("B001").isAvailable());
            System.out.println("D001 available after reload? " + reloaded.findItem("D001").isAvailable());
            System.out.println("Tariro's active loans after reload: "
                    + reloaded.findMember("M001").getActiveLoans().size());
        } catch (IOException e) {
            System.out.println("Storage problem: " + e.getMessage());
        }
    }
}
