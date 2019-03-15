import java.util.Arrays;

/**
 * Created by pradyumna on 2/2/19.
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductThreeNumbers {


    // Max product would be product of 3 max or 2 min(negative) and 1 max
    public int maximumProduct(int[] nums) {

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE, firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            } else if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }

        int firstProduct = firstMax * secondMax * thirdMax;
        int secondProduct = firstMax * firstMin * secondMin;

        return firstProduct > secondProduct ? firstProduct : secondProduct;
    }

    public static void main(String[] args) {
        MaximumProductThreeNumbers maximumProductThreeNumbers = new MaximumProductThreeNumbers();
        int[] nums = new int[]{1, 2, 3};
        int result = maximumProductThreeNumbers.maximumProduct(nums);
        System.out.println(result);
    }


}
