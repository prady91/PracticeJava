import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by pradyumna on 5/22/18.
 */

/*
 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes ↴ is no greater than one.
 */

public class SuperBalancedBinaryTree {


    public boolean isSuperBalancedBinaryTree(TreeNode node) {

        if (node == null) {
            return true;
        }

        Set<Integer> leafDepths = new HashSet<>();
        class tuple{
            TreeNode node;
            int depth;

            public tuple(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
        Stack<tuple> nodeStack = new Stack<>();
        nodeStack.push(new tuple(node, 0));

        while (!nodeStack.empty()) {

            tuple item = nodeStack.pop();
            TreeNode currNode = item.node;

            // Leaf node found
            if (currNode.left == null && currNode.right == null) {
                int depth = item.depth;
                leafDepths.add(depth);
                if (leafDepths.size() > 2 ||
                        leafDepths.stream().anyMatch(d -> Math.abs(d - depth) > 1)) {
                    return false;
                }
            } else {
                if (currNode.left != null) {
                    nodeStack.push(new tuple(node.left, item.depth+1));
                }
                if (currNode.right != null) {
                    nodeStack.push(new tuple(node.right, item.depth+1));
                }
            }
        }
        return true;
    }


    public static void main(String args[]) {



    }



}
