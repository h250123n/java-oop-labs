abstract class Account {
    protected final String accountNumber;
    protected double balance;

    Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    abstract double monthlyFee();

    void chargeMonthlyFee() {
        balance -= monthlyFee();
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, getClass().getSimpleName(), balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    double monthlyFee() { return 1.50; }
}

class CurrentAccount extends Account {
    CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    double monthlyFee() { return 10.00; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-1", 500),
            new CurrentAccount("CUR-1", 500)
        };

        for (Account a : accounts) {
            a.deposit(100);
            a.chargeMonthlyFee();
            System.out.println(a);
        }
    }
}
