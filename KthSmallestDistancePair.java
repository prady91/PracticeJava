import java.util.Arrays;

/**
 * Created by pradyumna on 12/15/18.
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 */
public class KthSmallestDistancePair {

    private int getNumPairsBelowTarget (int[] nums, int target) {
        int l = nums.length;
        int cnt = 0;
        for (int i = 0; i < l; i++) {
            int j = i+1;
            while (j < l && nums[j] - nums[i] <= target) {
                j++;
                cnt++;
            }
        }
        return cnt;
    }


    public int smallestDistancePair(int[] nums, int k) {
        int l = nums.length;
        Arrays.sort(nums);
        int high = nums[l-1]-nums[0];
        int low = nums[1]-nums[0];
        for (int i = 1; i < l-1; i++) {
            low = Math.min(low, nums[i+1] - nums[i]);
        }
        while (low < high) {
            int mid = low + (high-low)/2;
            int cnt = getNumPairsBelowTarget(nums, mid);
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main (String[] args) {
        KthSmallestDistancePair kthSmallestDistancePair = new KthSmallestDistancePair();
        int[] nums = new int[]{1, 3, 1};
        int kthSmallestDiff = kthSmallestDistancePair.smallestDistancePair(nums, 1);
        System.out.println(kthSmallestDiff);
    }
}
