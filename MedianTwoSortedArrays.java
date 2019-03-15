/**
 * Created by pradyumna on 9/13/18.
 */
public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k) {
        if (nums2.length > nums1.length) {
            return findMedianSortedArrays(nums2, nums1, s2, e2, s1, e1, k);
        }
        int mid = (s1+e1)/2;
        int m = nums1[mid];

        return 0.0;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int k = (l1+l2)/2;
        double r1 = findMedianSortedArrays(nums1, nums2, 0, nums1.length, 0, nums2.length, k);
        if ((l1+l2)%2 == 0) {
            double r2 =  findMedianSortedArrays(nums1, nums2, 0, nums1.length, 0, nums2.length, k-1);
            r1 = (r1+r2)/2;
        }
        return r1;
    }

}
