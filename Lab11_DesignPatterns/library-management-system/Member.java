import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private final String id;
    private final String name;
    private final List<Loan> activeLoans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = Validate.text(id, "Member id");
        this.name = Validate.text(name, "Member name");
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public List<Loan> getActiveLoans() {
        return Collections.unmodifiableList(activeLoans);
    }

    void addLoan(Loan loan)    { activeLoans.add(loan); }
    void removeLoan(Loan loan) { activeLoans.remove(loan); }

    @Override
    public String toString() {
        return String.format("[%s] %s (%d active loans)", id, name, activeLoans.size());
    }
}
