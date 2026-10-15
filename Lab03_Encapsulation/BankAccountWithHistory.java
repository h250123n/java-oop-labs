import java.util.ArrayList;
import java.util.List;

public class BankAccountWithHistory {

    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccountWithHistory(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add(String.format("Opened with %.2f", openingBalance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add(String.format("Deposit %.2f", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            history.add(String.format("Withdrawal of %.2f declined", amount));
            return false;
        }
        balance -= amount;
        history.add(String.format("Withdrawal %.2f", amount));
        return true;
    }

    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }

    public static void main(String[] args) {
        BankAccountWithHistory acc = new BankAccountWithHistory("ACC-002", "Nyasha", 300.00);
        acc.deposit(200.00);
        acc.withdraw(150.00);
        acc.withdraw(9000.00);

        System.out.println(acc);
        for (String entry : acc.getHistory()) {
            System.out.println("  " + entry);
        }

        try {
            acc.getHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified from outside");
        }
        System.out.println("Entries still recorded: " + acc.getHistory().size());
    }
}
