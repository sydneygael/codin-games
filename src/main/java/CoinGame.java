import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinGame {

    public static List<Map<Integer, Integer>> rendueMonnaie(int itemValue, int paidValue, List<Integer> availableCoins) {

        int coins = paidValue - itemValue;
        int som = 0;
        int nb = 0;

        int finalCoins = coins;
        List<Integer> coinsToUse = availableCoins
                .stream()
                .filter(coin -> coin <= finalCoins)
                .collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();

        while (som < coins) {
            Integer max = coinsToUse.stream().mapToInt(v -> v).max().orElse(1);
            nb = coins / max;
            coins = coins % max;
            map.put(max, nb);
            coinsToUse.removeIf(item -> item == max);
        }

        return Collections.singletonList(map);
    }

    public static void main(String[] args) {

        final List<Map<Integer, Integer>> maps = rendueMonnaie(275, 302, Arrays.asList(1,5,10,100));
        System.out.println("result: " + maps.toString());
    }
}
