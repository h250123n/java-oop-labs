public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-1", 800),
            new SavingsAccount("SAV-2", 200),
            new CurrentAccount("CUR-1", 300)
        };

        for (Account a : accounts) {
            a.deposit(100);
            a.applyMonthlyFee();
            System.out.printf("%s fee=%.2f balance=%.2f%n",
                    a.getNumber(), a.monthlyFee(), a.getBalance());
        }
    }
}
