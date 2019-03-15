/**
 * Created by pradyumna on 12/13/18.
 */
public class BinaryTreeMaxPathSum {


    public int getMaxPath (TreeNode root) {
        int maxContinuousPath = Integer.MIN_VALUE;
        if (root == null) {
            return maxContinuousPath;
        }

        int leftMaxContinuousPath = getMaxPath(root.left);
        int rightMaxContinuousPath = getMaxPath(root.right);

        maxContinuousPath = Math.max(leftMaxContinuousPath, rightMaxContinuousPath);
        if (maxContinuousPath > 0) {
            maxContinuousPath = Math.max(maxContinuousPath + root.val, root.val);
        } else{
            maxContinuousPath = root.val;
        }
        return maxContinuousPath;
    }

    public int maxPathSum(TreeNode root) {

        int maxSum = 0;

        if (root == null) {
            return maxSum;
        }

        int leftTreeOnlyMaxPathSum = maxPathSum(root.left);
        int rightTreeOnlyMaxPathSum = maxPathSum(root.right);
        int excludeRootMax = Math.max(leftTreeOnlyMaxPathSum, rightTreeOnlyMaxPathSum);

        int leftMaxSumChain = getMaxPath(root.left);
        int rightMaxSumChain = getMaxPath(root.right);

        int maxSumWithRoot = root.val;

        // Span on only one subtree
        if (leftMaxSumChain > 0) {
            maxSumWithRoot = Math.max(root.val+leftMaxSumChain, maxSumWithRoot);
        }
        if (rightMaxSumChain > 0) {
            maxSumWithRoot = Math.max(root.val+rightMaxSumChain, maxSumWithRoot);
        }

        // Span across both subtrees
        if (leftMaxSumChain > 0 && rightMaxSumChain > 0) {
            maxSumWithRoot = Math.max(maxSumWithRoot, root.val+leftMaxSumChain+rightMaxSumChain);
        }

        // Only root
        maxSumWithRoot = Math.max(root.val, maxSumWithRoot);

        maxSum = Math.max(excludeRootMax, maxSumWithRoot);

        return maxSum;
    }


}
