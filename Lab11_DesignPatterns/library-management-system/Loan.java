import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {

    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(LibraryItem item, Member member, LocalDate borrowDate) {
        if (item == null || member == null || borrowDate == null) {
            throw new IllegalArgumentException("Item, member and borrow date are required");
        }
        this.item = item;
        this.member = member;
        this.borrowDate = borrowDate;
    }

    public LibraryItem getItem()      { return item; }
    public Member getMember()         { return member; }
    public LocalDate getBorrowDate()  { return borrowDate; }
    public LocalDate getReturnDate()  { return returnDate; }

    public LocalDate getDueDate() {
        return borrowDate.plusDays(item.loanPeriodDays());
    }

    public boolean isActive() { return returnDate == null; }

    public boolean isOverdue(LocalDate today) {
        return isActive() && today.isAfter(getDueDate());
    }

    public long daysOverdue(LocalDate today) {
        return isOverdue(today) ? ChronoUnit.DAYS.between(getDueDate(), today) : 0;
    }

    void close(LocalDate date) {
        if (date.isBefore(borrowDate)) {
            throw new IllegalArgumentException("Return date cannot be before the borrow date");
        }
        this.returnDate = date;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s, borrowed %s, due %s%s",
                item.getTitle(), member.getName(), borrowDate, getDueDate(),
                isActive() ? "" : ", returned " + returnDate);
    }
}
