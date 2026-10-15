// Intermediate 1: abstract Account with a concrete deposit() and abstract monthlyFee()
abstract class Account {
    private final String number;
    private double balance;

    Account(String number, double openingBalance) {
        this.number = number;
        this.balance = openingBalance;
    }

    // concrete: identical for every account type
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // abstract: each account type charges a different fee
    abstract double monthlyFee();

    // concrete method that USES the abstract one (template pattern)
    void applyMonthlyFee() {
        balance -= monthlyFee();
    }

    double getBalance() { return balance; }
    String getNumber()  { return number; }
}

class SavingsAccount extends Account {
    SavingsAccount(String number, double openingBalance) { super(number, openingBalance); }

    // free if the balance is at least 500, otherwise 5.00
    @Override double monthlyFee() { return getBalance() >= 500 ? 0.0 : 5.00; }
}

class CurrentAccount extends Account {
    CurrentAccount(String number, double openingBalance) { super(number, openingBalance); }

    // flat fee
    @Override double monthlyFee() { return 10.00; }
}
