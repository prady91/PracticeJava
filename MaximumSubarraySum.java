import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by pradyumna on 4/16/17.
 */


//Given nums = [1, -1, 5, -2, 3], k = 3,
//return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/#/description

public class MaximumSubarraySum {

    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, max = 0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            sum += n;
            if(sum == k){
                max = i+1;
            }else if(sumMap.containsKey(sum-k)){
                max = Math.max(max, i-sumMap.get(sum-k));
            }
            if(!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }
        return max;
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        MaximumSubarraySum ob = new MaximumSubarraySum();
        int res = ob.maxSubArrayLen(nums, k);
        System.out.println(res);

    }

}
