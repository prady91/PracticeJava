import java.util.Arrays;

/**
 * Created by pradyumna on 11/12/18.
 */
public class CoinChange {


    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int[] coinMap = new int[amount+1];
        Arrays.fill(coinMap, -1);

        coinMap[0] = 0;
        for (int i = 0; i < amount; i++) {
            if (coinMap[i] == -1) {
                continue;
            }
            for (int coin : coins) {
                int subAmount = i+coin;
                if (subAmount > amount) {
                    continue;
                }
                if (coinMap[subAmount] == -1) {
                    coinMap[subAmount] = coinMap[i]+1;
                } else {
                    coinMap[subAmount] = Math.min(coinMap[i]+1, coinMap[subAmount]);
                }
            }
        }
        return coinMap[amount];
    }


    public static void main(String args[]) {
        CoinChange coinChangeObj = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChangeObj.coinChange(coins, 11));

        coins = new int[]{1};
        System.out.println(coinChangeObj.coinChange(coins, 2));

        coins = new int[]{1, 2147483647};
        System.out.println(coinChangeObj.coinChange(coins, 2147483647));

        coins = new int[]{1, 2147483647};
        System.out.println(coinChangeObj.coinChange(coins, 2));
    }


}
