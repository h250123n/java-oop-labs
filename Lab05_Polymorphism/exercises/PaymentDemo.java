abstract class Payment {
    protected final double amount;

    Payment(double amount) { this.amount = amount; }

    abstract void process();
}

class CardPayment extends Payment {
    private final String last4;

    CardPayment(double amount, String last4) {
        super(amount);
        this.last4 = last4;
    }

    String getLast4() { return last4; }

    @Override
    void process() {
        System.out.printf("Charging %.2f to card ending %s%n", amount, last4);
    }
}

class MobileMoneyPayment extends Payment {
    private final String phone;

    MobileMoneyPayment(double amount, String phone) {
        super(amount);
        this.phone = phone;
    }

    String getPhone() { return phone; }

    @Override
    void process() {
        System.out.printf("Sending %.2f via mobile money to %s%n", amount, phone);
    }
}

class CryptoPayment extends Payment {
    CryptoPayment(double amount) { super(amount); }

    @Override
    void process() {
        System.out.printf("Processing %.2f in crypto%n", amount);
    }
}

class PaymentProcessor {
    void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.printf("Charging %.2f to card ending %s%n", p.amount, c.getLast4());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.printf("Sending %.2f via mobile money to %s%n", p.amount, m.getPhone());
        } else {
            System.out.println("Unsupported payment type: " + p.getClass().getSimpleName());
        }
    }
}

class PolymorphicProcessor {
    void pay(Payment p) {
        p.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(120.00, "4417"),
            new MobileMoneyPayment(45.50, "0771234567"),
            new CryptoPayment(80.00)
        };

        System.out.println("--- instanceof version ---");
        PaymentProcessor old = new PaymentProcessor();
        for (Payment p : payments) {
            old.pay(p);
        }

        System.out.println("--- polymorphic version ---");
        PolymorphicProcessor modern = new PolymorphicProcessor();
        for (Payment p : payments) {
            modern.pay(p);
        }
    }
}
