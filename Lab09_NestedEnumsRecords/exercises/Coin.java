import java.util.EnumMap;
import java.util.Map;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Map<Coin, Integer> fewestCoins(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] coins = values();
        for (int i = coins.length - 1; i >= 0; i--) {
            int count = amount / coins[i].value;
            if (count > 0) {
                result.put(coins[i], count);
                amount -= count * coins[i].value;
            }
        }
        return result;
    }
}
