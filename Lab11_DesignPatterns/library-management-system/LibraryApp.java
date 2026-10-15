import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryApp {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        LibraryStorage storage = new LibraryStorage("data");

        try {
            storage.load(library);
            System.out.println("Loaded " + library.getItems().size() + " items and "
                    + library.getMembers().size() + " members.");
        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
            System.out.println("Starting with an empty library.");
            library = new Library();
        }

        boolean running = true;
        while (running) {
            printMenu();
            try {
                String choice = ask("Choose an option: ");
                switch (choice) {
                    case "1" -> addItem(library);
                    case "2" -> registerMember(library);
                    case "3" -> borrow(library);
                    case "4" -> giveBack(library);
                    case "5" -> listOverdue(library);
                    case "6" -> search(library);
                    case "7" -> library.getItems().forEach(System.out::println);
                    case "8" -> library.getMembers().forEach(System.out::println);
                    case "0" -> running = false;
                    default -> System.out.println("Please choose a number from the menu.");
                }
            } catch (IllegalArgumentException | ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println();
                System.out.println("Input ended.");
                running = false;
            }
        }

        try {
            storage.save(library);
            System.out.println("Data saved. Goodbye.");
        } catch (IOException e) {
            System.out.println("Could not save data: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Library Management System ===");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List all items");
        System.out.println("8. List all members");
        System.out.println("0. Save and exit");
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    private static void addItem(Library library) {
        String type = ask("Type (1 = Book, 2 = DVD): ");
        if (!type.equals("1") && !type.equals("2")) {
            throw new IllegalArgumentException("Type must be 1 or 2");
        }
        String id = ask("Item id: ");
        String title = ask("Title: ");

        LibraryItem item;
        if (type.equals("1")) {
            String author = ask("Author: ");
            item = new Book(id, title, author);
        } else {
            String text = ask("Runtime in minutes: ");
            int minutes;
            try {
                minutes = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Runtime must be a whole number");
            }
            item = new Dvd(id, title, minutes);
        }
        library.addItem(item);
        System.out.println("Added: " + item);
    }

    private static void registerMember(Library library) {
        String id = ask("Member id: ");
        String name = ask("Name: ");
        Member member = new Member(id, name);
        library.registerMember(member);
        System.out.println("Registered: " + member);
    }

    private static void borrow(Library library)
            throws ItemNotAvailableException, MemberLimitExceededException {
        String memberId = ask("Member id: ");
        String itemId = ask("Item id: ");
        Loan loan = library.borrow(memberId, itemId);
        System.out.println("Borrowed: " + loan);
    }

    private static void giveBack(Library library) {
        String itemId = ask("Item id: ");
        Loan loan = library.giveBack(itemId);
        System.out.println("Returned: " + loan);
        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            long late = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
            System.out.println("This item was returned " + late + " day(s) late.");
        }
    }

    private static void listOverdue(Library library) {
        LocalDate today = LocalDate.now();
        List<Loan> overdue = library.findOverdue(today);
        if (overdue.isEmpty()) {
            System.out.println("No overdue items.");
            return;
        }
        for (Loan loan : overdue) {
            System.out.printf("%s (%s) - %s, due %s, %d day(s) overdue%n",
                    loan.getItem().getTitle(), loan.getItem().getId(),
                    loan.getMember().getName(), loan.getDueDate(), loan.daysOverdue(today));
        }
    }

    private static void search(Library library) {
        String text = ask("Search for: ");
        List<LibraryItem> results = library.searchByTitle(text);
        if (results.isEmpty()) {
            System.out.println("No titles match \"" + text + "\".");
            return;
        }
        results.forEach(System.out::println);
    }
}
