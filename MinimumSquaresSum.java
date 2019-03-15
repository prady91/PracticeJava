/**
 * Created by pradyumna on 3/6/19.
 *
 * https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
 *
 */
public class MinimumSquaresSum {



    public int getMinSquares(int target) {

        if (target == 1) {
            return 1;
        }

        int min = target;

        for (int i = 1; i <= target; i++) {
            int partialSum = i*i;
            if (partialSum > target) {
                break;
            }
            min = Math.min(min, 1 + getMinSquares(target-partialSum));
        }

        return min;
    }


    public int getMinSquareDp (int target) {
        if (target == 1) {
            return 1;
        }

        int min = target;
        int[] dp = new int[target+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int current = 4; current <= target; current++) {

            dp[current] = current;

            for (int i = 1; i <= current; i++) {
                int partialSum = i*i;
                if (partialSum > current) {
                    break;
                }
                dp[current] = Math.min(dp[current], 1+dp[current-partialSum]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        MinimumSquaresSum minimumSquaresSum = new MinimumSquaresSum();

        int result = minimumSquaresSum.getMinSquares(5);

        System.out.println(result);

    }

}
