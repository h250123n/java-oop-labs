import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {

    public static final int MAX_LOANS_PER_MEMBER = 3;

    private final Map<String, LibraryItem> items = new TreeMap<>();
    private final Map<String, Member> members = new TreeMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with id " + member.getId() + " already exists");
        }
        members.put(member.getId(), member);
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        return borrow(memberId, itemId, LocalDate.now());
    }

    public Loan borrow(String memberId, String itemId, LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);

        if (member.getActiveLoans().size() >= MAX_LOANS_PER_MEMBER) {
            throw new MemberLimitExceededException(memberId, MAX_LOANS_PER_MEMBER);
        }
        item.borrow(member);

        Loan loan = new Loan(item, member, date);
        loans.add(loan);
        member.addLoan(loan);
        return loan;
    }

    public Loan giveBack(String itemId) {
        return giveBack(itemId, LocalDate.now());
    }

    public Loan giveBack(String itemId, LocalDate date) {
        LibraryItem item = findItem(itemId);
        Loan loan = loans.stream()
            .filter(l -> l.isActive() && l.getItem() == item)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Item " + itemId + " is not on loan"));

        loan.close(date);
        item.giveBack();
        loan.getMember().removeLoan(loan);
        return loan;
    }

    void restoreLoan(String itemId, String memberId, LocalDate borrowDate, LocalDate returnDate) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        Loan loan = new Loan(item, member, borrowDate);

        if (returnDate == null) {
            try {
                item.borrow(member);
            } catch (ItemNotAvailableException e) {
                throw new IllegalArgumentException("Saved data lists " + itemId + " as on loan twice");
            }
            member.addLoan(loan);
        } else {
            loan.close(returnDate);
        }
        loans.add(loan);
    }

    public List<Loan> findOverdue(LocalDate today) {
        return loans.stream()
            .filter(l -> l.isOverdue(today))
            .sorted(Comparator.comparing(Loan::getDueDate))
            .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
            .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .toList();
    }

    public LibraryItem findItem(String id) {
        LibraryItem item = items.get(id);
        if (item == null) {
            throw new IllegalArgumentException("No item with id " + id);
        }
        return item;
    }

    public Member findMember(String id) {
        Member member = members.get(id);
        if (member == null) {
            throw new IllegalArgumentException("No member with id " + id);
        }
        return member;
    }

    public Collection<LibraryItem> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }

    public Collection<Member> getMembers() {
        return Collections.unmodifiableCollection(members.values());
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }
}
