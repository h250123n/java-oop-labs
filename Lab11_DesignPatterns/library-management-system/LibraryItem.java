public abstract class LibraryItem implements Borrowable {

    private final String id;
    private final String title;
    private boolean available = true;
    private Member borrower;

    protected LibraryItem(String id, String title) {
        this.id = Validate.text(id, "Item id");
        this.title = Validate.text(title, "Title");
    }

    public abstract int loanPeriodDays();

    public abstract String type();

    public abstract String extraField();

    public String getId()       { return id; }
    public String getTitle()    { return title; }
    public Member getBorrower() { return borrower; }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (member == null) {
            throw new IllegalArgumentException("Member is required");
        }
        if (!available) {
            throw new ItemNotAvailableException(id, title);
        }
        available = false;
        borrower = member;
    }

    @Override
    public void giveBack() {
        available = true;
        borrower = null;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-4s \"%s\" - %d-day loan, %s",
                id, type(), title, loanPeriodDays(), available ? "available" : "on loan");
    }
}
