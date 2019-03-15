/**
 * Created by pradyumna on 2/24/19.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LCABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftTarget = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTarget = lowestCommonAncestor(root.right, p, q);

        if (leftTarget != null && rightTarget != null) {
            return root;
        }
        return (leftTarget != null) ? leftTarget : rightTarget;
    }

}
