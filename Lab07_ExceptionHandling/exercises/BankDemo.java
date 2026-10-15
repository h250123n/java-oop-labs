public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);
        acc.deposit(250.00);
        System.out.println(acc);

        try {
            acc.withdraw(100.00);
            System.out.println("Withdrew 100");
            acc.withdraw(5000.00);               // throws
            System.out.println("never printed");
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
        System.out.println(acc);                 // state unchanged by the failed withdrawal
    }
}
