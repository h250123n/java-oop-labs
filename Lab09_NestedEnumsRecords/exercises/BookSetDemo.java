import java.util.HashSet;
import java.util.Set;

public class BookSetDemo {
    public static void main(String[] args) {
        Set<Book> library = new HashSet<>();

        boolean first = library.add(new Book("978-0132350884", "Clean Code"));
        boolean second = library.add(new Book("978-0134685991", "Effective Java"));
        boolean duplicate = library.add(new Book("978-0132350884", "Clean Code (copy)"));

        System.out.println("Added first: " + first);
        System.out.println("Added second: " + second);
        System.out.println("Added duplicate: " + duplicate);
        System.out.println("Library size: " + library.size());
    }
}
