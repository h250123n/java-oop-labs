public class Book extends LibraryItem {

    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = Validate.text(author, "Author");
    }

    public String getAuthor() { return author; }

    @Override
    public int loanPeriodDays() { return 14; }

    @Override
    public String type() { return "BOOK"; }

    @Override
    public String extraField() { return author; }

    @Override
    public String toString() {
        return super.toString() + ", by " + author;
    }
}
