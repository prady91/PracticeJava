/**
 * Created by pradyumna on 1/6/19.
 */
public class BinaryTreeMaxPathSumGlobalState {


    public int getMaxSubtreePath(TreeNode root, IntegerContainer integerContainer) {
        if (root == null) {
            return 0;
        }
        int leftPathSum = Math.max(0, getMaxSubtreePath(root.left, integerContainer));
        int rightPathSum = Math.max(0, getMaxSubtreePath(root.right, integerContainer));

        integerContainer.value = Math.max(integerContainer.value, root.val+leftPathSum+rightPathSum);
        return root.val+Math.max(leftPathSum, rightPathSum);
    }


    public int maxPathSum(TreeNode root) {

        IntegerContainer integerContainer = new IntegerContainer();
        integerContainer.value = Integer.MIN_VALUE;
        getMaxSubtreePath(root, integerContainer);
        return integerContainer.value;
    }

}

class IntegerContainer {
    Integer value;
}
