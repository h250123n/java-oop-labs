import java.util.Map;

public class CoinDemo {
    public static void main(String[] args) {
        int[] amounts = {68, 41, 5, 99, 0};

        for (int amount : amounts) {
            Map<Coin, Integer> change = Coin.fewestCoins(amount);
            int total = 0;
            for (int count : change.values()) {
                total += count;
            }
            System.out.println(amount + " cents -> " + change + " (" + total + " coins)");
        }
    }
}
